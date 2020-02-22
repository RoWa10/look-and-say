import java.io.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
	
	static long totalDuration;
	
	@BeforeAll
	static void beforeAll() {
		totalDuration = 0;
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println( String.format( "All solutions took %01d.%03d secs",  totalDuration / 1000,  totalDuration % 1000 ));
	}
	
	@ParameterizedTest
	@CsvFileSource( resources = "testdata.csv" )
	void main( final String input, final String expected ) throws IOException {
		// keep original streams
		InputStream oldIn = System.in;
		PrintStream oldOut = System.out;
		PrintStream oldErr = System.err;
		ByteArrayOutputStream bos =  new ByteArrayOutputStream();
		
		try {
			redirectStreams(
					new ByteArrayInputStream( input.getBytes( UTF_8 )),
					new PrintStream( bos, true, UTF_8 ),
					new PrintStream( new ByteArrayOutputStream(), true, UTF_8 )
			);
			
			// start time tracking
			long start = System.currentTimeMillis();
			
			Solution.main( new String[0] );
			
			// stop time tracking
			long duration = System.currentTimeMillis() - start;
			totalDuration += duration;
			
			// restore streams
			redirectStreams( oldIn, oldOut, oldErr );
			
			System.out.println( String.format( "Solution took %01d.%03d secs",  duration / 1000,  duration % 1000 ));
			
			try (BufferedReader chk = new BufferedReader( new InputStreamReader( new ByteArrayInputStream( bos.toByteArray() )))) {
				String[] expectedLines = expected.split( "\\s*[|]\\s*" );
				
				int lineCount = 0;
				String line;
				for ( ; (line = chk.readLine()) != null; lineCount++ ) {
					assertEquals( expectedLines[ lineCount ], line );
				}
				assertEquals( expectedLines.length, lineCount );
			}
		}
		finally {
			// restore streams
			redirectStreams( oldIn, oldOut, oldErr );
		}
	}
	
	static void redirectStreams( final InputStream input, final PrintStream output, final PrintStream error ) {
		System.setIn( input );
		System.setOut( output );
		System.setErr( error );
	}
}

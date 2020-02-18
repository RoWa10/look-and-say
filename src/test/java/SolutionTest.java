import java.io.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
	
	@ParameterizedTest
	@CsvFileSource( resources = "testdata.csv" )
	void main( final String input, final String expected ) throws IOException {
		InputStream oldIn = System.in;
		PrintStream oldOut = System.out;
		PrintStream oldErr = System.err;
		
		try {
			InputStream in = new ByteArrayInputStream( input.getBytes() );
			System.setIn( in );
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut( new PrintStream( out ) );
			
			ByteArrayOutputStream err = new ByteArrayOutputStream();
			System.setErr( new PrintStream( err ) );
			
			// start time tracking
			long start = System.currentTimeMillis();
			
			Solution.main( new String[ 0 ] );
			out.flush();
			
			// stop time tracking
			long end = System.currentTimeMillis();
			
			// restore streams
			System.setIn( oldIn );
			System.setOut( oldOut );
			System.setErr( oldErr );
			
			System.out.println( String.format( "Solution took %01d.%03d secs", ( end - start ) / 1000, ( end - start ) % 1000 ) );
			
			try (BufferedReader chk = new BufferedReader( new InputStreamReader( new ByteArrayInputStream( out.toByteArray() )))) {
				assertEquals( expected, chk.readLine() );
			}
		}
		finally {
			// restore streams
			System.setIn( oldIn );
			System.setOut( oldOut );
			System.setErr( oldErr );
		}
	}
}

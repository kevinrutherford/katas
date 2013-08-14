package triviaGame;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class GoldenMaster {

	private static final String MASTER_FILENAME = "./master.txt";

	public String currentValue() {
		try {
			if (!masterFile().exists())
				generate();
			return readFileAsString();
		} catch (IOException e) {
			return "";
		}
	}
	
	private void generate() throws FileNotFoundException {
		GameRunner.runAThousandGames(new PrintStream(MASTER_FILENAME));
	}

	private String readFileAsString() throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(MASTER_FILENAME));
		try {
			long len = masterFile().length();
			if (len > Integer.MAX_VALUE)
				throw new IOException("File " + MASTER_FILENAME + " too large, was " + len + " bytes.");
			byte[] bytes = new byte[(int) len];
			dis.readFully(bytes);
			return new String(bytes, "UTF-8");
		} finally {
			dis.close();
		}
	}

	private File masterFile() {
		return new File(MASTER_FILENAME);
	}

}

// by Dave Jagoda
// bibliography:
// http://docs.oracle.com/javase/7/docs/api/java/lang/Character.htm
// http://java.sun.com/developer/technicalArticles/Intl/Supplementary/
// http://docs.oracle.com/javase/tutorial/i18n/text/examples/StreamConverter.java
// http://www.ssec.wisc.edu/~tomw/java/unicode.html
// tested with Java7 on Linux
// invocation: /usr/lib/jvm/java-1.7.0-openjdk-amd64/bin/java utf8 utf8.txt

import java.io.PrintStream;
import java.io.IOException;

public class utf8 {
    static String getUnicodeData(int codePoint) {
	String c, n = null;
	c = new String(Character.toChars(codePoint));
	n = Character.getName(codePoint);
	return c + " " + n;
    }
    public static void main (String[] args) throws IOException {
	String filename = null;
	if (args.length == 1) {
	    filename = args[0];
	} else {
	    System.err.println("usage: java utf8 <file to create with utf8 data>");
	    System.exit(1);
	}
	PrintStream out = new PrintStream(filename, "UTF-8");
	for (int i = 0; i < 0x10000; i++) {
	    String newString = getUnicodeData(i);
	    out.printf("%04x %s\n", i, newString);
	}
    }
}

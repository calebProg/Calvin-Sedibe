package python;

import Oracle.BibleVerse;
import py4j.GatewayServer;

import py4j.GatewayServer;

public class BibleVerseGateway {
    BibleVerse bibleVerse;
    public BibleVerseGateway() {
        bibleVerse = new BibleVerse();
    }

    public BibleVerse getBibleVerse() {
        return bibleVerse;
    }
    public static void main(String[] args) {
        GatewayServer server = new GatewayServer(new BibleVerseGateway());
        server.start();
        System.out.println("Gateway Server Started!");
    }
}


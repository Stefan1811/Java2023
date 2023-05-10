import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader stdIn;

    public GameClient(String serverAddress, int serverPort) {
        try {
            clientSocket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to server " + serverAddress + " on port " + serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Server response: " + response);
                if (userInput.equals("exit")) {
                    break;
                }
            }
            in.close();
            out.close();
            stdIn.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change the server address as needed
        int serverPort = 8100; // Change the server port number as needed
        GameClient gameClient = new GameClient(serverAddress, serverPort);
        gameClient.start();
    }
}

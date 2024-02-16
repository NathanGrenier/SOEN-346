
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /**
     * main class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Network objNetwork = new Network("network"); /* Activate the network */
        objNetwork.start();

        Server objServer = new Server();
        objServer.start();

        Client objClientSending = new Client("sending");
        objClientSending.start();

        Client objClientRecieving = new Client("receiving");
        objClientRecieving.start();
    }
}

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;


public class Server {

    public ArrayList<Player> playerList;
    public ArrayList<Territory> map;
    public int port;
    public ServerSocket serverSocket;
    private BasicChecker ruleChecker;
    public Server(int port) throws IOException {
        playerList = new ArrayList<>();
        map = new ArrayList<>();
        this.port = port;
        serverSocket = new ServerSocket(this.port);
        ruleChecker = new OriginChecker(new DestinationChecker(null));
    }
    public void acceptPlayer(int playerNum) throws IOException {
        for(int i = 0; i < playerNum; i++){
            Player p = new Player(port, i+1);
            p.connectToServer();
            Socket playerSocket = serverSocket.accept();
            System.out.println("Accept new connection from " + playerSocket.getInetAddress());
            playerList.add(p);
            System.out.println("Added player"+p.getID()+" to list");
            Thread playerThread = new Thread(p);
            playerThread.start();
        }
    }

    public void gameStart(){}


    public void initialzeMapHelper(){

    }


    ArrayList<Map.Entry<String, Integer>> mapInfo;

    public void initialzeMap(){
        int playerNum = playerList.size();
        map.add(new Territory("Narnia", -1));
        map.add(new Territory("Midkemia", -1));
        map.add(new Territory("Oz", -1));
        map.add(new Territory("Gondor", -1));
        map.add(new Territory("Elantris", -1));
        map.add(new Territory("Scadrial", -1));
        map.add(new Territory("Roshar", -1));
        map.add(new Territory("Hogwarts", -1));
        if(playerNum != 3 || playerNum != 4){
            map.add(new Territory("Mordor", -1));
        }
        if(playerNum != 4){
            map.add(new Territory("Duke", -1));
        }






        if(playerNum == 2){

        }else if(playerNum == 3){

        }else if(playerNum == 4){

        }else if(playerNum == 5){

        }
    }

    public void playTurn(){}

    private void checkBehavior(ArrayList<Behavior>){}

    public void sendPlayerStatus(){}

    public void gameOver(){}




}

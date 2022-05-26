import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;

/**
 * NFT Clicker game!!!
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display extends Application
{
    // Initialize text labels
    private Label moneyLabel = new Label("0 NFTs");
    private Label incomeVisual = new Label("0 NFTs/s)");

    //Initialize money stuff
    private static long income = 0;
    private static long money = 0;

    //Income multiplier array
    private boolean[] upgrades = new boolean[7];

    private int imageCount = 0;

    //Initialize Image ArrayList
    ArrayList<Image> images = new ArrayList<Image>();

    //Initialize ImageView ArrayList
    ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    
    //Create Buttons
    Button nftButton = new Button();

    Button artistButton = new Button("Buy Underpaid Pixel Artist: " + 10.0);
    Button gamerButton = new Button("Buy Play-to-earn NFT Gamer: " + 100.0);
    Button royaltiesButton = new Button("Buy NFT Royalties: " + 1000.0);
    Button marketplaceButton = new Button("Buy NFT Marketplace: " + 8000.0);
    Button minterButton = new Button("Buy Memelord Minter: " + 50000.0);
    Button basketballCardButton = new Button("Buy Basketball Card NFT: " + 333333.3);
    Button generatedArtButton = new Button("Buy Procedurally Generated Art: " + 2000000.0);
    Button rugPullButton = new Button("Buy Celebrity Rug Pull: " + 10000000.0);

    Button overtimeButton = new Button("OVERTIME - Doubles output of all Underpaid Pixel Artists: 99.0");
    Button gamingButton = new Button("HARDCORD GAMING - Doubles output of all Play-to-earn NFT Gamers: 1500.0");
    Button ratesButton = new Button("HIGHER RATES - Doubles output of all NFT Royalties: 18,000.0");
    Button tradingButton = new Button("WASH TRADING - Doubles output of all NFT Marketplaces: 50,000.0");
    Button dankButton = new Button("DANKER MEMES - Doubles output of all Memelord Minters: 777,777.0");
    Button celebrityButton = new Button("HIRE CELEBRITY - Doubles all NFT collection: 9,876,543.0");
    Button metaverseButton = new Button("BUY THE METAVERSE - Dramatically increases output of all generators: 2 BILLION NFTs");

    //Create generator ArrayList
    ArrayList<Generator> generators = new ArrayList<Generator>();

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //Create / initialize generators
        createGenerator("Artists", 10, 1, 0, 30, 0, true);
        createGenerator("Gamers", 100, 3, 0, 30, 0, true);
        createGenerator("Royalties", 1000, 27, 0, 30, 0, true);
        createGenerator("Marketplaces", 8000, 144, 0, 30, 0, true);
        createGenerator("Minters", 50000, 899, 0, 30, 0, true);
        createGenerator("Basketball Cards", 333333, 4567, 0, 30, 0, true);
        createGenerator("Generated Art", 2000000, 20314, 0, 30, 0, true);
        createGenerator("Rug Pull", 10000000, 987654, 0, 30, 0, true);

        //Create ImageViews for each Image
        /*
        for(int i = 0; i <= 68; i++)
        {
            imageViews.add(new ImageView(new Image("/d" + i + ".jpg", 200, 200, false, false)));
        }
        */
        
        for(int i = 0; i <= 68; i++)
        {
            imageViews.add(new ImageView(new Image("/d" + i + ".jpg", false)));
        }
        
        //Add initial image to nftButton
        changeImage();

        //Set actions on the buttons using method reference
        nftButton.setOnAction(event -> buttonClick());
        artistButton.setOnAction(event -> buyGen(0));
        gamerButton.setOnAction(event -> buyGen(1));
        royaltiesButton.setOnAction(event -> buyGen(2));
        marketplaceButton.setOnAction(event -> buyGen(3));
        minterButton.setOnAction(event -> buyGen(4));
        basketballCardButton.setOnAction(event -> buyGen(5));
        generatedArtButton.setOnAction(event -> buyGen(6));
        rugPullButton.setOnAction(event -> buyGen(7));

        overtimeButton.setOnAction(event -> {
                if (money >= 99 && !upgrades[0])
                {
                    money -= 99;
                    upgrades[0] = true;
                    generators.get(0).setGenIncome(generators.get(0).getGenIncome() * 2);
                    overtimeButton.setText("OVERTIME - BOUGHT");
                    updateIncome();
                }
            });
        gamingButton.setOnAction(event -> {
                if (money >= 1500 && !upgrades[1])
                {
                    money -= 1500;
                    upgrades[1] = true;
                    generators.get(1).setGenIncome(generators.get(1).getGenIncome() * 2);
                    gamingButton.setText("HARDCORE GAMING - BOUGHT");
                    updateIncome();
                }
            });
        ratesButton.setOnAction(event -> {
                if (money >= 1800 && !upgrades[2])
                {
                    money -= 1800;
                    upgrades[2] = true;
                    generators.get(2).setGenIncome(generators.get(2).getGenIncome() * 2);
                    ratesButton.setText("HIGHER RATES - BOUGHT");
                    updateIncome();
                }
            });
        tradingButton.setOnAction(event -> {
                if (money >= 50000 && !upgrades[3])
                {
                    money -= 50000;
                    upgrades[3] = true;
                    generators.get(3).setGenIncome(generators.get(3).getGenIncome() * 2);
                    tradingButton.setText("WASH TRADING - BOUGHT");
                    updateIncome();
                }
            });
        dankButton.setOnAction(event -> {
                if (money >= 777777 && !upgrades[4])
                {
                    money -= 777777;
                    upgrades[4] = true;
                    generators.get(4).setGenIncome(generators.get(4).getGenIncome() * 2);
                    dankButton.setText("DANKER MEMES - BOUGHT");
                    updateIncome();
                }
            });
        celebrityButton.setOnAction(event -> {
                if (money >= 9876543 && !upgrades[5])
                {
                    money -= 9876543;
                    upgrades[5] = true;
                    celebrityButton.setText("HIRE CELEBRITY - BOUGHT");
                    updateIncome();
                }
            });
        metaverseButton.setOnAction(event -> {
                if (money >= 2000000000 && !upgrades[6])
                {
                    money -= 2000000000;
                    upgrades[6] = true;
                    metaverseButton.setText("BUY THE METAVERSE - BOUGHT");
                    updateIncome();
                }
            });

        // Add the buttons and labels into the pane
        pane.add(moneyLabel, 1, 0);
        pane.add(nftButton, 0, 0);

        pane.add(artistButton, 2, 1);
        pane.add(gamerButton, 2, 2);
        pane.add(royaltiesButton, 2, 3);
        pane.add(marketplaceButton, 2, 4);
        pane.add(minterButton, 2, 5);
        pane.add(basketballCardButton, 2, 6);
        pane.add(generatedArtButton, 2, 7);
        pane.add(rugPullButton, 2, 8);

        pane.add(overtimeButton, 3, 1);
        pane.add(gamingButton, 3, 2);
        pane.add(ratesButton, 3, 3);
        pane.add(tradingButton, 3, 4);
        pane.add(dankButton, 3, 5);
        pane.add(celebrityButton, 3, 6);
        pane.add(metaverseButton, 3, 7);

        pane.add(incomeVisual, 0, 1);

        //Set text of buttons
        artistButton.setText("Buy Underpaid Pixel Artist: " + generators.get(0).getPrice());
        gamerButton.setText("Buy Play-to-earn NFT Gamer: " + generators.get(1).getPrice());
        royaltiesButton.setText("Buy NFT Royalties: " + generators.get(2).getPrice());
        marketplaceButton.setText("Buy NFT Marketplace: " + generators.get(3).getPrice());
        minterButton.setText("Buy Memelord Minter: " + generators.get(4).getPrice());
        basketballCardButton.setText("Buy Basketball Card NFT: " + generators.get(5).getPrice());
        generatedArtButton.setText("Buy Procedurally Generated Art: " + generators.get(6).getPrice());
        rugPullButton.setText("Buy Celebrity Rug Pull: " + generators.get(7).getPrice());

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 1000,1000);
        stage.setTitle("NFT Clicker");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();

        //Create the 1 second timer to run game ticks
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
            {
                @Override
                public void run()
                {
                    Platform.runLater(() ->
                        {
                            gameTick();
                        });

                }
            }, 0, 1000);
    }

    public void gameTick()
    {
        money += income;

        gameUpdate();
    }

    //Getter methods
    public static long getIncome()
    {
        return income;
    }

    public static long getMoney()
    {
        return money;
    }

    //Buy method
    public void buyGen(int i)
    {
        if (money >= generators.get(i).getPrice())
        {
            money -= generators.get(i).getPrice();
            generators.get(i).buyGenerator();
            gameUpdate();
        }
    }

    public void updateIncome()
    {
        long temp = 0;

        for(int i = 0; i < generators.size(); i++)
        {
            temp += (generators.get(i).getAmount() * generators.get(i).getGenIncome());
        }

        income = temp;
        if (upgrades[5])
        {
            income *= 2;
        }
        if (upgrades[6])
        {
            income *= 10;
        }

        if (income == 1)
        {
            incomeVisual.setText(income + " NFT/s");
        }
        else if (income >= 1000000)
        {
            incomeVisual.setText(Utility.round((double) income / 1000000) + " million NFTs/s");
        }
        else
        {
            incomeVisual.setText(income + " NFTs/s");
        }
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick()
    {
        // Counts number of button clicks and shows the result on a label
        money++;
        updateMoney();
        changeImage();
    }

    private void gameUpdate()
    {
        //Update money
        updateMoney();

        //Update generator prices
        artistButton.setText("Buy Underpaid Pixel Artist: " + generators.get(0).getPrice());
        gamerButton.setText("Buy Play-to-earn NFT Gamer: " + generators.get(1).getPrice());
        royaltiesButton.setText("Buy NFT Royalties: " + generators.get(2).getPrice());
        marketplaceButton.setText("Buy NFT Marketplace: " + generators.get(3).getPrice());
        minterButton.setText("Buy Memelord Minter: " + generators.get(4).getPrice());
        basketballCardButton.setText("Buy Basketball Card NFT: " + generators.get(5).getPrice());
        generatedArtButton.setText("Buy Procedurally Generated Art: " + generators.get(6).getPrice());
        rugPullButton.setText("Buy Celebrity Rug Pull: " + generators.get(7).getPrice());

        //Update generator visibilities
        for(int i = 0; i < generators.size(); i++)
        {
            if(!generators.get(i).visibility() && money >= generators.get(i).getVisibleAmount())
            {
                generators.get(i).toggleVisibility();
            }
        }

        //Update income
        updateIncome();
    }

    public void updateMoney()
    {
        if (money == 1.0)
        {
            moneyLabel.setText(money + " NFT");
        }
        else if (money >= 1000000000)
        {
            moneyLabel.setText(Utility.round((double) (money / 1000000) / 1000) + " billion NFTs");
        }
        else if (money >= 1000000)
        {
            moneyLabel.setText(Utility.round((double) money / 1000000) + " million NFTs");
        }
        else
        {
            moneyLabel.setText(money + " NFTs");
        }
    }

    public void createGenerator(String name, long startCost, long genIncome, int amount, double increaseRate, long visibleAmount, boolean visibility)
    {
        //Initialize generator object
        Generator addThis = new Generator(name, startCost, genIncome, amount, increaseRate, visibleAmount, visibility);

        //Add generator to the ArrayList
        generators.add(addThis);
    }

    
    private void changeImage()
    {  
        nftButton.setVisible(false);

        int temp = (int)(Math.random() * imageViews.size());
        
        while(temp == imageCount)
        {
            temp = (int)(Math.random() * imageViews.size());
        }

        imageCount = temp;
        
        imageViews.get(imageCount).setFitHeight(200);
        imageViews.get(imageCount).setFitWidth(200);
        nftButton.setGraphic(imageViews.get(imageCount));
        nftButton.setVisible(true);
    }
}

/*
Underpaid pixel artist
Play-to-earn NFT gamer
NFT royalties
NFT marketplace
Memelord minter
Basketball card NFTs
Procedurally generated art
Celebrity rug pull
 */
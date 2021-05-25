import java.util.Date;
import java.util.Random;

public class DataGenerator {

    public static final double EVENTS_PER_SECONDS = 100000.0;

    public static final long TIME_DISTANCE_MS = 1000L;
    public  static final long NUMBER_OF_EVENTS = 100000L;

    public static void main(String[] args){

        String[] userNames = {"Andy", "Bob", "Carl", "Dave", "Esther", "Fanny", "Gabe", "Imogen", "John", "Louis", "Monica"};
        String[] regionNames = {"America", "Europe", "Asia", "Australia", "Africa"};


        JsonSerializer<Click> subser = new JsonSerializer<>();
        Delayer delayer = new Delayer(EVENTS_PER_SECONDS);

        int userLength = userNames.length;
        int regionLength = regionNames.length;

        Random userChoice = new Random();
        Random regionChoice = new Random();

        long startTime = System.currentTimeMillis();
        long i =0L;

        for (long j = 0; j < NUMBER_OF_EVENTS; j++){
            Click temp = new Click(new Date(startTime+i), userNames[userChoice.nextInt(userLength)], regionNames[regionChoice.nextInt(regionLength)]);
            delayer.apply(temp);
            outputEvent(subser.toJSONString(temp));
            i += TIME_DISTANCE_MS;
        }
    }

    public static void outputEvent(String record){
        System.out.println(record);
    }


}

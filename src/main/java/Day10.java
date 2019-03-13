import Objects.GridFrame;
import Objects.GridToPrint;
import Objects.Star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 {

    private static List<String> input = Arrays.asList("position=<31351,-51811>velocity=<-3,5>",
            "position=<21001,31317>velocity=<-2,-3>",
            "position=<-41347,-41423>velocity=<4,4>",
            "position=<-20557,52103>velocity=<2,-5>",
            "position=<-30975,41713>velocity=<3,-4>",
            "position=<10618,-20633>velocity=<-1,2>",
            "position=<31358,-10242>velocity=<-3,1>",
            "position=<10564,-10247>velocity=<-1,1>",
            "position=<-20586,-31033>velocity=<2,3>",
            "position=<10617,52095>velocity=<-1,-5>",
            "position=<-30972,-51814>velocity=<3,5>",
            "position=<21000,-10244>velocity=<-2,1>",
            "position=<-30968,20931>velocity=<3,-2>",
            "position=<-20573,20926>velocity=<2,-2>",
            "position=<-10222,-41421>velocity=<1,4>",
            "position=<10561,10531>velocity=<-1,-1>",
            "position=<-10202,-31033>velocity=<1,3>",
            "position=<-31004,-20633>velocity=<3,2>",
            "position=<-51734,10533>velocity=<5,-1>",
            "position=<-10198,10540>velocity=<1,-1>",
            "position=<52168,20930>velocity=<-5,-2>",
            "position=<-31001,-31024>velocity=<3,3>",
            "position=<-10201,52095>velocity=<1,-5>",
            "position=<52124,20926>velocity=<-5,-2>",
            "position=<-20573,-20641>velocity=<2,2>",
            "position=<-10190,20927>velocity=<1,-2>",
            "position=<52129,-31026>velocity=<-5,3>",
            "position=<10568,31315>velocity=<-1,-3>",
            "position=<52126,41704>velocity=<-5,-4>",
            "position=<-20610,52095>velocity=<2,-5>",
            "position=<10568,10540>velocity=<-1,-1>",
            "position=<-30988,-20639>velocity=<3,2>",
            "position=<31347,10537>velocity=<-3,-1>",
            "position=<10579,20926>velocity=<-1,-2>",
            "position=<-20605,31322>velocity=<2,-3>",
            "position=<31382,31319>velocity=<-3,-3>",
            "position=<20979,-20633>velocity=<-2,2>",
            "position=<-30976,20931>velocity=<3,-2>",
            "position=<20996,10536>velocity=<-2,-1>",
            "position=<10604,10538>velocity=<-1,-1>",
            "position=<-20553,-31024>velocity=<2,3>",
            "position=<-41338,-10242>velocity=<4,1>",
            "position=<41765,41708>velocity=<-4,-4>",
            "position=<21007,-31029>velocity=<-2,3>",
            "position=<41758,-20642>velocity=<-4,2>",
            "position=<-51743,-41419>velocity=<5,4>",
            "position=<-10171,-41420>velocity=<1,4>",
            "position=<31366,-51808>velocity=<-3,5>",
            "position=<-51741,-20635>velocity=<5,2>",
            "position=<10569,41708>velocity=<-1,-4>",
            "position=<41741,52104>velocity=<-4,-5>",
            "position=<52144,-20642>velocity=<-5,2>",
            "position=<41762,10540>velocity=<-4,-1>",
            "position=<41733,-31030>velocity=<-4,3>",
            "position=<31369,10540>velocity=<-3,-1>",
            "position=<-10196,-41415>velocity=<1,4>",
            "position=<31391,-20635>velocity=<-3,2>",
            "position=<21002,31317>velocity=<-2,-3>",
            "position=<-51770,-31026>velocity=<5,3>",
            "position=<-20587,10531>velocity=<2,-1>",
            "position=<31395,-10250>velocity=<-3,1>",
            "position=<41786,41712>velocity=<-4,-4>",
            "position=<41789,20931>velocity=<-4,-2>",
            "position=<20967,52100>velocity=<-2,-5>",
            "position=<10605,31320>velocity=<-1,-3>",
            "position=<10609,-20640>velocity=<-1,2>",
            "position=<52153,-20641>velocity=<-5,2>",
            "position=<-31004,20928>velocity=<3,-2>",
            "position=<41778,31320>velocity=<-4,-3>",
            "position=<-41363,52099>velocity=<4,-5>",
            "position=<41737,31317>velocity=<-4,-3>",
            "position=<41758,52101>velocity=<-4,-5>",
            "position=<-51786,-51811>velocity=<5,5>",
            "position=<21002,-31029>velocity=<-2,3>",
            "position=<41765,-31027>velocity=<-4,3>",
            "position=<-20565,52103>velocity=<2,-5>",
            "position=<21007,-10245>velocity=<-2,1>",
            "position=<52124,-10243>velocity=<-5,1>",
            "position=<41753,-41420>velocity=<-4,4>",
            "position=<-51754,20924>velocity=<5,-2>",
            "position=<-30964,-51812>velocity=<3,5>",
            "position=<41775,-20639>velocity=<-4,2>",
            "position=<31395,41713>velocity=<-3,-4>",
            "position=<21007,-10244>velocity=<-2,1>",
            "position=<10592,20927>velocity=<-1,-2>",
            "position=<-41377,-10247>velocity=<4,1>",
            "position=<-20557,10532>velocity=<2,-1>",
            "position=<41733,20928>velocity=<-4,-2>",
            "position=<-51781,-10243>velocity=<5,1>",
            "position=<10593,41713>velocity=<-1,-4>",
            "position=<-41379,-10242>velocity=<4,1>",
            "position=<-51783,31313>velocity=<5,-3>",
            "position=<-41337,-41420>velocity=<4,4>",
            "position=<-41338,-20638>velocity=<4,2>",
            "position=<41749,52100>velocity=<-4,-5>",
            "position=<52142,52095>velocity=<-5,-5>",
            "position=<10612,10533>velocity=<-1,-1>",
            "position=<31391,-51812>velocity=<-3,5>",
            "position=<52125,-41424>velocity=<-5,4>",
            "position=<10612,-41418>velocity=<-1,4>",
            "position=<31342,20929>velocity=<-3,-2>",
            "position=<-51770,-20638>velocity=<5,2>",
            "position=<41750,-10247>velocity=<-4,1>",
            "position=<20951,-10247>velocity=<-2,1>",
            "position=<-20557,-10244>velocity=<2,1>",
            "position=<-41363,20929>velocity=<4,-2>",
            "position=<41782,-20636>velocity=<-4,2>",
            "position=<41746,52095>velocity=<-4,-5>",
            "position=<10576,52103>velocity=<-1,-5>",
            "position=<-10198,-31026>velocity=<1,3>",
            "position=<31387,-10242>velocity=<-3,1>",
            "position=<-51758,41704>velocity=<5,-4>",
            "position=<52148,52095>velocity=<-5,-5>",
            "position=<-31004,-10250>velocity=<3,1>",
            "position=<-41358,20930>velocity=<4,-2>",
            "position=<-41386,-31033>velocity=<4,3>",
            "position=<31387,10535>velocity=<-3,-1>",
            "position=<-30996,52101>velocity=<3,-5>",
            "position=<10619,20926>velocity=<-1,-2>",
            "position=<41754,41704>velocity=<-4,-4>",
            "position=<-41339,31318>velocity=<4,-3>",
            "position=<41761,-31030>velocity=<-4,3>",
            "position=<-20608,31320>velocity=<2,-3>",
            "position=<10560,-31028>velocity=<-1,3>",
            "position=<-30972,41706>velocity=<3,-4>",
            "position=<21004,-51807>velocity=<-2,5>",
            "position=<52125,41713>velocity=<-5,-4>",
            "position=<-41355,41709>velocity=<4,-4>",
            "position=<52176,20928>velocity=<-5,-2>",
            "position=<-10188,10540>velocity=<1,-1>",
            "position=<-20557,-31027>velocity=<2,3>",
            "position=<52132,52096>velocity=<-5,-5>",
            "position=<52140,20930>velocity=<-5,-2>",
            "position=<10584,-10243>velocity=<-1,1>",
            "position=<-30943,-51815>velocity=<3,5>",
            "position=<-30947,-31024>velocity=<3,3>",
            "position=<31378,52095>velocity=<-3,-5>",
            "position=<-20571,-10248>velocity=<2,1>",
            "position=<20999,31314>velocity=<-2,-3>",
            "position=<-30963,-51813>velocity=<3,5>",
            "position=<31390,-41415>velocity=<-3,4>",
            "position=<-20609,-41420>velocity=<2,4>",
            "position=<10568,31318>velocity=<-1,-3>",
            "position=<31342,20923>velocity=<-3,-2>",
            "position=<31347,-20641>velocity=<-3,2>",
            "position=<-10193,-20642>velocity=<1,2>",
            "position=<-41347,10532>velocity=<4,-1>",
            "position=<-41379,10533>velocity=<4,-1>",
            "position=<20959,20929>velocity=<-2,-2>",
            "position=<52135,-20642>velocity=<-5,2>",
            "position=<41761,31316>velocity=<-4,-3>",
            "position=<-20568,10531>velocity=<2,-1>",
            "position=<-10193,-20640>velocity=<1,2>",
            "position=<-41342,41705>velocity=<4,-4>",
            "position=<-20568,41704>velocity=<2,-4>",
            "position=<41745,10535>velocity=<-4,-1>",
            "position=<-20603,10531>velocity=<2,-1>",
            "position=<52157,-10251>velocity=<-5,1>",
            "position=<52142,-10247>velocity=<-5,1>",
            "position=<10576,-31030>velocity=<-1,3>",
            "position=<41750,52099>velocity=<-4,-5>",
            "position=<31390,10540>velocity=<-3,-1>",
            "position=<-51781,41705>velocity=<5,-4>",
            "position=<10600,-10242>velocity=<-1,1>",
            "position=<41737,-20642>velocity=<-4,2>",
            "position=<-41370,-41415>velocity=<4,4>",
            "position=<20980,-10250>velocity=<-2,1>",
            "position=<21007,31321>velocity=<-2,-3>",
            "position=<10562,-20642>velocity=<-1,2>",
            "position=<-30952,-41417>velocity=<3,4>",
            "position=<-31004,52104>velocity=<3,-5>",
            "position=<52129,10532>velocity=<-5,-1>",
            "position=<-51730,-41424>velocity=<5,4>",
            "position=<-20613,-51808>velocity=<2,5>",
            "position=<-10214,41706>velocity=<1,-4>",
            "position=<-41368,-20633>velocity=<4,2>",
            "position=<31403,31322>velocity=<-3,-3>",
            "position=<52153,20922>velocity=<-5,-2>",
            "position=<-51736,-41419>velocity=<5,4>",
            "position=<10568,-20642>velocity=<-1,2>",
            "position=<41741,-20641>velocity=<-4,2>",
            "position=<41743,-10251>velocity=<-4,1>",
            "position=<-30944,-31024>velocity=<3,3>",
            "position=<20956,10538>velocity=<-2,-1>",
            "position=<-41350,20931>velocity=<4,-2>",
            "position=<-30992,-51811>velocity=<3,5>",
            "position=<-31001,31313>velocity=<3,-3>",
            "position=<20959,41709>velocity=<-2,-4>",
            "position=<-10214,-41420>velocity=<1,4>",
            "position=<-51766,-20638>velocity=<5,2>",
            "position=<52140,20923>velocity=<-5,-2>",
            "position=<31358,31314>velocity=<-3,-3>",
            "position=<20956,31315>velocity=<-2,-3>",
            "position=<41789,-31031>velocity=<-4,3>",
            "position=<-20585,-41415>velocity=<2,4>",
            "position=<31390,10539>velocity=<-3,-1>",
            "position=<31370,20922>velocity=<-3,-2>",
            "position=<-30970,31322>velocity=<3,-3>",
            "position=<41785,31320>velocity=<-4,-3>",
            "position=<-10162,-41415>velocity=<1,4>",
            "position=<-20569,31320>velocity=<2,-3>",
            "position=<52177,41704>velocity=<-5,-4>",
            "position=<21009,31317>velocity=<-2,-3>",
            "position=<31345,-41420>velocity=<-3,4>",
            "position=<-41335,52099>velocity=<4,-5>",
            "position=<-51733,-20634>velocity=<5,2>",
            "position=<-41345,-51811>velocity=<4,5>",
            "position=<-41368,-20638>velocity=<4,2>",
            "position=<-10203,-41424>velocity=<1,4>",
            "position=<-20597,-51809>velocity=<2,5>",
            "position=<-51778,-41418>velocity=<5,4>",
            "position=<31400,41704>velocity=<-3,-4>",
            "position=<41734,-31029>velocity=<-4,3>",
            "position=<52184,-31029>velocity=<-5,3>",
            "position=<20967,41707>velocity=<-2,-4>",
            "position=<-51746,31315>velocity=<5,-3>",
            "position=<10600,-41417>velocity=<-1,4>",
            "position=<41775,-31030>velocity=<-4,3>",
            "position=<21010,-41415>velocity=<-2,4>",
            "position=<-10166,41707>velocity=<1,-4>",
            "position=<52166,41708>velocity=<-5,-4>",
            "position=<-41355,-31027>velocity=<4,3>",
            "position=<-20597,-31028>velocity=<2,3>",
            "position=<31355,31313>velocity=<-3,-3>",
            "position=<-30972,-41422>velocity=<3,4>",
            "position=<-51725,20922>velocity=<5,-2>",
            "position=<31382,20930>velocity=<-3,-2>",
            "position=<-30946,-51811>velocity=<3,5>",
            "position=<52132,-20640>velocity=<-5,2>",
            "position=<-10177,-51814>velocity=<1,5>",
            "position=<10605,-20633>velocity=<-1,2>",
            "position=<31376,-20642>velocity=<-3,2>",
            "position=<-20573,52095>velocity=<2,-5>",
            "position=<-41358,52096>velocity=<4,-5>",
            "position=<-10218,-41415>velocity=<1,4>",
            "position=<52180,31321>velocity=<-5,-3>",
            "position=<10605,20927>velocity=<-1,-2>",
            "position=<-20557,-41418>velocity=<2,4>",
            "position=<52164,20928>velocity=<-5,-2>",
            "position=<10565,10539>velocity=<-1,-1>",
            "position=<31395,-51815>velocity=<-3,5>",
            "position=<20967,-20635>velocity=<-2,2>",
            "position=<20967,10538>velocity=<-2,-1>",
            "position=<10562,10535>velocity=<-1,-1>",
            "position=<-20605,20925>velocity=<2,-2>",
            "position=<-30948,-31024>velocity=<3,3>",
            "position=<-10206,52099>velocity=<1,-5>",
            "position=<-10217,-51810>velocity=<1,5>",
            "position=<10596,10531>velocity=<-1,-1>",
            "position=<20977,-51810>velocity=<-2,5>",
            "position=<-10213,-10247>velocity=<1,1>",
            "position=<31378,-10242>velocity=<-3,1>",
            "position=<10580,-51811>velocity=<-1,5>",
            "position=<-30999,41710>velocity=<3,-4>",
            "position=<-41387,31318>velocity=<4,-3>",
            "position=<31374,52096>velocity=<-3,-5>",
            "position=<52169,10531>velocity=<-5,-1>",
            "position=<-30994,-31029>velocity=<3,3>",
            "position=<41777,-41416>velocity=<-4,4>",
            "position=<21004,-31024>velocity=<-2,3>",
            "position=<41736,-20633>velocity=<-4,2>",
            "position=<10579,20922>velocity=<-1,-2>",
            "position=<-41387,-51808>velocity=<4,5>",
            "position=<-20561,10534>velocity=<2,-1>",
            "position=<-51728,-31033>velocity=<5,3>",
            "position=<31352,20922>velocity=<-3,-2>",
            "position=<-30944,41704>velocity=<3,-4>",
            "position=<52135,41708>velocity=<-5,-4>",
            "position=<-30948,-10242>velocity=<3,1>",
            "position=<-20568,-41423>velocity=<2,4>",
            "position=<41753,-31033>velocity=<-4,3>",
            "position=<31360,52095>velocity=<-3,-5>",
            "position=<-41338,31317>velocity=<4,-3>",
            "position=<20975,20922>velocity=<-2,-2>",
            "position=<20951,41706>velocity=<-2,-4>",
            "position=<-51746,-20639>velocity=<5,2>",
            "position=<10587,-10247>velocity=<-1,1>",
            "position=<-51778,-20638>velocity=<5,2>",
            "position=<-51741,20925>velocity=<5,-2>",
            "position=<10605,41710>velocity=<-1,-4>",
            "position=<-51781,52100>velocity=<5,-5>",
            "position=<10600,31314>velocity=<-1,-3>",
            "position=<-51778,-31025>velocity=<5,3>",
            "position=<-51778,-41418>velocity=<5,4>",
            "position=<10592,-10248>velocity=<-1,1>",
            "position=<-10177,20924>velocity=<1,-2>",
            "position=<-10185,31321>velocity=<1,-3>",
            "position=<20987,-41415>velocity=<-2,4>",
            "position=<-10211,52095>velocity=<1,-5>",
            "position=<20986,-10251>velocity=<-2,1>",
            "position=<-10218,-41424>velocity=<1,4>",
            "position=<-10181,31314>velocity=<1,-3>",
            "position=<-51760,-31028>velocity=<5,3>",
            "position=<41759,-41415>velocity=<-4,4>",
            "position=<-30954,-51811>velocity=<3,5>",
            "position=<-31004,20922>velocity=<3,-2>",
            "position=<52164,52100>velocity=<-5,-5>",
            "position=<-30964,-31031>velocity=<3,3>",
            "position=<31358,-41420>velocity=<-3,4>",
            "position=<52141,41704>velocity=<-5,-4>",
            "position=<10585,-51815>velocity=<-1,5>",
            "position=<-20557,-51812>velocity=<2,5>",
            "position=<-10169,-10251>velocity=<1,1>",
            "position=<10576,52095>velocity=<-1,-5>",
            "position=<-10170,41707>velocity=<1,-4>",
            "position=<31363,-41424>velocity=<-3,4>",
            "position=<-41339,20927>velocity=<4,-2>",
            "position=<-30978,52095>velocity=<3,-5>",
            "position=<-51786,-10245>velocity=<5,1>",
            "position=<-41371,31322>velocity=<4,-3>",
            "position=<-30996,20925>velocity=<3,-2>",
            "position=<31374,20930>velocity=<-3,-2>",
            "position=<52175,-10246>velocity=<-5,1>",
            "position=<31374,41710>velocity=<-3,-4>",
            "position=<-10182,52099>velocity=<1,-5>",
            "position=<-10206,41713>velocity=<1,-4>",
            "position=<-20557,-31026>velocity=<2,3>",
            "position=<31377,52104>velocity=<-3,-5>",
            "position=<10608,-41424>velocity=<-1,4>",
            "position=<-30964,-20638>velocity=<3,2>",
            "position=<-51741,-10243>velocity=<5,1>",
            "position=<52156,31321>velocity=<-5,-3>",
            "position=<31354,31313>velocity=<-3,-3>",
            "position=<20980,20922>velocity=<-2,-2>",
            "position=<-20556,-10242>velocity=<2,1>",
            "position=<52129,-20636>velocity=<-5,2>",
            "position=<20976,41704>velocity=<-2,-4>",
            "position=<-10198,41712>velocity=<1,-4>",
            "position=<31394,-41417>velocity=<-3,4>",
            "position=<-20573,52098>velocity=<2,-5>",
            "position=<-41350,20928>velocity=<4,-2>",
            "position=<52156,10532>velocity=<-5,-1>",
            "position=<-31002,20926>velocity=<3,-2>",
            "position=<-30999,10534>velocity=<3,-1>",
            "position=<52177,52104>velocity=<-5,-5>",
            "position=<-30978,31322>velocity=<3,-3>",
            "position=<-30959,31318>velocity=<3,-3>",
            "position=<-51741,-31031>velocity=<5,3>",
            "position=<31344,-10242>velocity=<-3,1>",
            "position=<-41386,-10251>velocity=<4,1>",
            "position=<41738,-10243>velocity=<-4,1>",
            "position=<41778,-10245>velocity=<-4,1>",
            "position=<41774,-41422>velocity=<-4,4>",
            "position=<-10166,20927>velocity=<1,-2>",
            "position=<21011,41708>velocity=<-2,-4>",
            "position=<-30988,-31027>velocity=<3,3>",
            "position=<-41339,-51815>velocity=<4,5>",
            "position=<31385,-10245>velocity=<-3,1>",
            "position=<-41369,52095>velocity=<4,-5>",
            "position=<52129,10533>velocity=<-5,-1>",
            "position=<21010,-41424>velocity=<-2,4>",
            "position=<-30964,10533>velocity=<3,-1>");

    public static void partOne() {
        System.out.println("Day Ten, Part One:");
        List<Star> stars = generateStars();

        int seconds = 0;
        GridToPrint currentGrid = new GridToPrint();
        boolean contracting = true;
        while (contracting) {
            GridToPrint newGrid = generateGrid(stars, seconds, currentGrid);
            if (newGrid != null) {
                currentGrid = newGrid;
            } else {
                contracting = false;
            }
            moveStars(stars);
            seconds++;
        }

        currentGrid.printGrid();
    }

    private static GridToPrint generateGrid(List<Star> stars, int seconds, GridToPrint currentGrid) {
        int[] minAndMaxXAndY = findMinAndMaxXAndY(stars);

        GridToPrint returnGrid = null;
        if (minAndMaxXAndY[3] - minAndMaxXAndY[2] < currentGrid.getyDist()) {
            returnGrid = new GridToPrint(seconds, stars, minAndMaxXAndY[0], minAndMaxXAndY[1], minAndMaxXAndY[2], minAndMaxXAndY[3]);
        }

        return returnGrid;
    }

    private static int[] findMinAndMaxXAndY(List<Star> stars) {
        int minX = Integer.MAX_VALUE;
        int maxX = 0;
        int minY = Integer.MAX_VALUE;
        int maxY = 0;

        for (Star star : stars) {
            int xPosition = star.getxPosition();
            if (xPosition > maxX) {
                maxX = xPosition;
            }

            if (xPosition < minX) {
                minX = xPosition;
            }

            int yPosition = star.getyPosition();
            if (yPosition > maxY) {
                maxY = yPosition;
            }

            if (yPosition < minY) {
                minY = yPosition;
            }
        }

        return new int[]{minX, maxX, minY, maxY};
    }

    private static void moveStars(List<Star> stars) {
        stars.forEach(Star::move);
    }

    private static List<Star> generateStars() {
        List<Star> stars = new ArrayList<>();
        for (String str : input) {
            String position = str.substring(str.indexOf("position=<") + "position=<".length(), str.indexOf(">velocity=<"));
            String velocity = str.substring(str.indexOf(">velocity=<") + ">velocity=<".length()).replace(">", "");
            int xPosition = Integer.parseInt(position.substring(0, position.indexOf(",")));
            int yPosition = Integer.parseInt(position.substring(position.indexOf(",") + 1));
            int xVelocity = Integer.parseInt(velocity.substring(0, velocity.indexOf(",")));
            int yVelocity = Integer.parseInt(velocity.substring(velocity.indexOf(",") + 1));
            stars.add(new Star(xPosition, yPosition, xVelocity, yVelocity));
        }
        return stars;
    }
}

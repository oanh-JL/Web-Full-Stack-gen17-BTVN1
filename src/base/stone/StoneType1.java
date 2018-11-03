package base.stone;

import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StoneType1 extends Stone {
    public StoneType1() {
        List<String> listStones = Arrays.asList(
                "assets/images/stone/rock5.png",
                "assets/images/stone/rock6.png",
                "assets/images/stone/rock7.png",
                "assets/images/stone/rock8.png",
                "assets/images/stone/rock9.png"
                );
        Random rand = new Random();
        int randomIndex = rand.nextInt(listStones.size());
        String randomElement = listStones.get(randomIndex);
        this.renderer = new SingleImageRenderer(randomElement);

    }


}

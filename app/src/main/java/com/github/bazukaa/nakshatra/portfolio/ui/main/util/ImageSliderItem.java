package com.github.bazukaa.nakshatra.portfolio.ui.main.util;

import java.util.SplittableRandom;

public class ImageSliderItem {
    private String imageUrl;
    private String imageDescription;

    public ImageSliderItem(String imageUrl, String imageDescription) {
        this.imageUrl = imageUrl;
        this.imageDescription = imageDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}

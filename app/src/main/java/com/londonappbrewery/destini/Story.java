package com.londonappbrewery.destini;

public class Story {
    private int storyID,ans1ID,ans2ID;

    public Story(int storyID, int ans1ID, int ans2ID) {
        this.storyID = storyID;
        this.ans1ID = ans1ID;
        this.ans2ID = ans2ID;
    }

    public int getStoryID() {
        return storyID;
    }

    public void setStoryID(int storyID) {
        this.storyID = storyID;
    }

    public int getAns1ID() {
        return ans1ID;
    }

    public void setAns1ID(int ans1ID) {
        this.ans1ID = ans1ID;
    }

    public int getAns2ID() {
        return ans2ID;
    }

    public void setAns2ID(int ans2ID) {
        this.ans2ID = ans2ID;
    }
}

package com.megvii.facepp.api.bean;

/**
 * @author by licheng on 2018/9/26.
 */

public class Landmark {

    private Point head; //	头部
    private Point neck; //Object	脖子
    private Point left_shoulder; //	Object	左肩
    private Point left_elbow; //	Object	左肘
    private Point left_hand; //	Object	左手
    private Point right_shoulder; //	Object	右肩
    private Point right_elbow; //	Object	右肘
    private Point right_hand; // Object	右手
    private Point left_buttocks; //	Object	左臀
    private Point left_knee; //Object	左膝
    private Point left_foot; //	Object	左脚
    private Point right_buttocks; //Object	右臀
    private Point right_knee; //	Object	右膝
    private Point right_foot; //Object	右脚

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public Point getNeck() {
        return neck;
    }

    public void setNeck(Point neck) {
        this.neck = neck;
    }

    public Point getLeft_shoulder() {
        return left_shoulder;
    }

    public void setLeft_shoulder(Point left_shoulder) {
        this.left_shoulder = left_shoulder;
    }

    public Point getLeft_elbow() {
        return left_elbow;
    }

    public void setLeft_elbow(Point left_elbow) {
        this.left_elbow = left_elbow;
    }

    public Point getLeft_hand() {
        return left_hand;
    }

    public void setLeft_hand(Point left_hand) {
        this.left_hand = left_hand;
    }

    public Point getRight_shoulder() {
        return right_shoulder;
    }

    public void setRight_shoulder(Point right_shoulder) {
        this.right_shoulder = right_shoulder;
    }

    public Point getRight_elbow() {
        return right_elbow;
    }

    public void setRight_elbow(Point right_elbow) {
        this.right_elbow = right_elbow;
    }

    public Point getRight_hand() {
        return right_hand;
    }

    public void setRight_hand(Point right_hand) {
        this.right_hand = right_hand;
    }

    public Point getLeft_buttocks() {
        return left_buttocks;
    }

    public void setLeft_buttocks(Point left_buttocks) {
        this.left_buttocks = left_buttocks;
    }

    public Point getLeft_knee() {
        return left_knee;
    }

    public void setLeft_knee(Point left_knee) {
        this.left_knee = left_knee;
    }

    public Point getLeft_foot() {
        return left_foot;
    }

    public void setLeft_foot(Point left_foot) {
        this.left_foot = left_foot;
    }

    public Point getRight_buttocks() {
        return right_buttocks;
    }

    public void setRight_buttocks(Point right_buttocks) {
        this.right_buttocks = right_buttocks;
    }

    public Point getRight_knee() {
        return right_knee;
    }

    public void setRight_knee(Point right_knee) {
        this.right_knee = right_knee;
    }

    public Point getRight_foot() {
        return right_foot;
    }

    public void setRight_foot(Point right_foot) {
        this.right_foot = right_foot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Landmark landmark = (Landmark) o;

        if (head != null ? !head.equals(landmark.head) : landmark.head != null) return false;
        if (neck != null ? !neck.equals(landmark.neck) : landmark.neck != null) return false;
        if (left_shoulder != null ? !left_shoulder.equals(landmark.left_shoulder) : landmark.left_shoulder != null)
            return false;
        if (left_elbow != null ? !left_elbow.equals(landmark.left_elbow) : landmark.left_elbow != null)
            return false;
        if (left_hand != null ? !left_hand.equals(landmark.left_hand) : landmark.left_hand != null)
            return false;
        if (right_shoulder != null ? !right_shoulder.equals(landmark.right_shoulder) : landmark.right_shoulder != null)
            return false;
        if (right_elbow != null ? !right_elbow.equals(landmark.right_elbow) : landmark.right_elbow != null)
            return false;
        if (right_hand != null ? !right_hand.equals(landmark.right_hand) : landmark.right_hand != null)
            return false;
        if (left_buttocks != null ? !left_buttocks.equals(landmark.left_buttocks) : landmark.left_buttocks != null)
            return false;
        if (left_knee != null ? !left_knee.equals(landmark.left_knee) : landmark.left_knee != null)
            return false;
        if (left_foot != null ? !left_foot.equals(landmark.left_foot) : landmark.left_foot != null)
            return false;
        if (right_buttocks != null ? !right_buttocks.equals(landmark.right_buttocks) : landmark.right_buttocks != null)
            return false;
        if (right_knee != null ? !right_knee.equals(landmark.right_knee) : landmark.right_knee != null)
            return false;
        return right_foot != null ? right_foot.equals(landmark.right_foot) : landmark.right_foot == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (neck != null ? neck.hashCode() : 0);
        result = 31 * result + (left_shoulder != null ? left_shoulder.hashCode() : 0);
        result = 31 * result + (left_elbow != null ? left_elbow.hashCode() : 0);
        result = 31 * result + (left_hand != null ? left_hand.hashCode() : 0);
        result = 31 * result + (right_shoulder != null ? right_shoulder.hashCode() : 0);
        result = 31 * result + (right_elbow != null ? right_elbow.hashCode() : 0);
        result = 31 * result + (right_hand != null ? right_hand.hashCode() : 0);
        result = 31 * result + (left_buttocks != null ? left_buttocks.hashCode() : 0);
        result = 31 * result + (left_knee != null ? left_knee.hashCode() : 0);
        result = 31 * result + (left_foot != null ? left_foot.hashCode() : 0);
        result = 31 * result + (right_buttocks != null ? right_buttocks.hashCode() : 0);
        result = 31 * result + (right_knee != null ? right_knee.hashCode() : 0);
        result = 31 * result + (right_foot != null ? right_foot.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"head\":" + head +
                ", \"neck\":" + neck +
                ", \"left_shoulder\":" + left_shoulder +
                ", \"left_elbow\":" + left_elbow +
                ", \"left_hand\":" + left_hand +
                ", \"right_shoulder\":" + right_shoulder +
                ", \"right_elbow\":" + right_elbow +
                ", \"right_hand\":" + right_hand +
                ", \"left_buttocks\":" + left_buttocks +
                ", \"left_knee\":" + left_knee +
                ", \"left_foot\":" + left_foot +
                ", \"right_buttocks\":" + right_buttocks +
                ", \"right_knee\":" + right_knee +
                ", \"right_foot\":" + right_foot +
                '}';
    }
}

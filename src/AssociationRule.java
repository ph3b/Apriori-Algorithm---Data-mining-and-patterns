import java.util.ArrayList;

public class AssociationRule {
    private ItemSet leftSide;
    private ItemSet rightSide;
    private Double confidence;
    private Double support;

    public AssociationRule(ItemSet leftSide, ItemSet rightSide){
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String toString(){
        return this.leftSide.toString() + ";" + this.rightSide.toString();
    }

    public Double getConfidence() {
        return confidence;
    }

    public boolean equals(AssociationRule associationRule){
        return (this.getLeftSide().equals(associationRule.getLeftSide()) &&
                this.getRightSide().equals(associationRule.getRightSide()) ||
                (this.getLeftSide().equals(associationRule.getRightSide()) &&
                        this.getRightSide().equals(associationRule.getLeftSide()))
        );
    }

    public void setConfidence(Double confidence) {
        if(confidence < 0) return;
        this.confidence = confidence;
    }

    public ItemSet getRightSide() {
        return rightSide;
    }

    public ItemSet getLeftSide() {
        return leftSide;
    }
}

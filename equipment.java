package sample.model;

public class equipment {
    private  String equipment;
    private String poleDistance;
    private String lightIntensity;
    private String carrierMedium;
    private String lightDistance;
    private String magTech;

    public equipment() {
    }

    public equipment(String equipment, String poleDistance, String lightIntensity, String carrierMedium, String lightDistance, String magTech) {
        this.equipment = equipment;
        this.poleDistance = poleDistance;
        this.lightIntensity = lightIntensity;
        this.carrierMedium = carrierMedium;
        this.lightDistance = lightDistance;
        this.magTech = magTech;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPoleDistance() {
        return poleDistance;
    }

    public void setPoleDistance(String poleDistance) {
        this.poleDistance = poleDistance;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(String lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public String getCarrierMedium() {
        return carrierMedium;
    }

    public void setCarrierMedium(String carrierMedium) {
        this.carrierMedium = carrierMedium;
    }

    public String getLightDistance() {
        return lightDistance;
    }

    public void setLightDistance(String lightDistance) {
        this.lightDistance = lightDistance;
    }

    public String getMagTech() {
        return magTech;
    }

    public void setMagTech(String magTech) {
        this.magTech = magTech;
    }


    @Override
    public String toString() {
        return this.getEquipment();
    }
}

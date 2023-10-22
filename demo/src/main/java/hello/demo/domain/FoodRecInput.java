package hello.demo.domain;

import jakarta.persistence.*;
@Entity
public class FoodRecInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="userId")
    private Member userId;

    private String cookedCategory;
    private String selectedKcal;
    private  String selectedCar;
    private String selectedProtein;
    private String selectedFat;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(String selectedCar) {
        this.selectedCar = selectedCar;
    }

    public String getSelectedFat() {
        return selectedFat;
    }

    public void setSelectedFat(String selectedFat) {
        this.selectedFat = selectedFat;
    }

    public String getSelectedKcal() {
        return selectedKcal;
    }

    public void setSelectedKcal(String selectedKcal) {
        this.selectedKcal = selectedKcal;
    }

    public String getSelectedProtein() {
        return selectedProtein;
    }

    public void setSelectedProtein(String selectedProtein) {
        this.selectedProtein = selectedProtein;
    }

    public Member getUserId() {
        return userId;
    }

    public void setUserId(Member userId) {
        this.userId = userId;
    }

    public String getCookedCategory() {
        return cookedCategory;
    }

    public void setCookedCategory(String cookedCategory) {
        this.cookedCategory = cookedCategory;
    }
}

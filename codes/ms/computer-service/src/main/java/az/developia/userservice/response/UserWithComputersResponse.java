
package az.developia.userservice.response;

import java.util.List;

import az.developia.userservice.entity.User;

public class UserWithComputersResponse {

    private User user;
    private List<ComputerDto> computers;

    public UserWithComputersResponse() {
    }

    public UserWithComputersResponse(
            User user, List<ComputerDto> computers) {
        this.user = user;
        this.computers = computers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ComputerDto> getComputers() {
        return computers;
    }

    public void setComputers(List<ComputerDto> computers) {
        this.computers = computers;
    }

    public static class ComputerDto {

        private Long id;
        private String brand;
        private String model;
        private Double price;
        private Long userId;

        public ComputerDto() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}

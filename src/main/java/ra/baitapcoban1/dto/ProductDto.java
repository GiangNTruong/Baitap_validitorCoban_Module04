package ra.baitapcoban1.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    @NotBlank(message = "productName is empty")
    private String productName;
    @NotBlank(message = "Producer is empty")
    private String producer;
    @NotNull(message = "yearOfManufacture is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "yearOfManufacture is not valid")
    private Date yearOfManufacture;
    @NotNull(message = "expirationDate is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "expirationDate is not valid")
    private Date expirationDate;
    @NotNull(message = "price is empty" )
    private Double price;
}

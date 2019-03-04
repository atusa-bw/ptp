package edu.msudenver.tsp.persistence.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountDto extends BaseDto implements Serializable {
    @NotBlank(groups = Insert.class, message = "A username must be specified") @Size(max = 50) private String username;
    @NotBlank(groups = Insert.class, message = "A password must be specified") @Size(max = 256) private String password;
    @NotNull private boolean administrator_status;
    @Temporal(TemporalType.DATE) private Date last_login;

    public static final long serialVersionUID = 7095627971593953734L;

    public interface Insert {}
}

package com.rso.swap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empid;

	@Column(name="empcode", unique = true)
    @NotNull
    @Getter
    @Setter
	private int empcode;

	@Column(name="name")
    @NotNull
    @Getter
    @Setter
	private String name;

    @Column(name="email")
    @NotNull
    @Getter
    @Setter
	private String email;

    @Column(name="password")
    @NotNull
    @Getter
    @Setter
    private String password;

    @Column(name="phone")
    @NotNull
    @Getter
    @Setter
    private String phone;

    @Column(name="type")
    @NotNull
    @Getter
    @Setter
    private String type;

    /*@JsonCreator
    public Employee (@JsonProperty("userId") Integer userId) {
        this.userId = userId;
    }*/

    /*@OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "userId")
    @JsonManagedReference
    private List<Shift> shifts = new ArrayList<Shift>();

    public void addShift(Shift shift) {
        shifts.add(shift);
        shift.setEmployee(this);
    }
*/

}

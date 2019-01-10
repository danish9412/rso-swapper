package com.rso.swap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table (name = "shift")
@AllArgsConstructor
@NoArgsConstructor
public class Shift implements Serializable {

    @Id
    @Column(name = "shift_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shiftId;
	
	@Column(name="give")
    @Getter
    @Setter
	private String give;
	
	@Column(name="need")
    @Getter
    @Setter
	private String need;

    @Column(name="empcode")
    @NotNull
    @Getter
    @Setter
    private String empcode;

}

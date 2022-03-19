package com.ultrasonic.checksheet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Shiva Created on 09/03/22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JointRange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateCreated = new Date(System.currentTimeMillis());
    private String updatedBy;

    // Joint 1
    private BigDecimal J7RW_MIN=new BigDecimal("2.00");
    private BigDecimal J7RY_MIN=new BigDecimal("2.00");
    private BigDecimal J7RH_MIN=new BigDecimal("2.00");
    private BigDecimal J7RD_MIN=new BigDecimal("2.00");
    private BigDecimal J7RL_MIN=new BigDecimal("2.00");
    private BigDecimal J7RP_MIN=new BigDecimal("2.00");

    private BigDecimal J12LW_MIN=new BigDecimal("2.00");
    private BigDecimal J12LY_MIN=new BigDecimal("2.00");
    private BigDecimal J12LH_MIN=new BigDecimal("2.00");
    private BigDecimal J12LD_MIN=new BigDecimal("2.00");
    private BigDecimal J12LL_MIN=new BigDecimal("2.00");
    private BigDecimal J12LP_MIN=new BigDecimal("2.00");

    // Joint 2
    private BigDecimal J8RW_MIN=new BigDecimal("2.00");
    private BigDecimal J8RY_MIN=new BigDecimal("2.00");
    private BigDecimal J8RH_MIN=new BigDecimal("2.00");
    private BigDecimal J8RD_MIN=new BigDecimal("2.00");
    private BigDecimal J8RL_MIN=new BigDecimal("2.00");
    private BigDecimal J8RP_MIN=new BigDecimal("2.00");

    private BigDecimal J13LW_MIN=new BigDecimal("2.00");
    private BigDecimal J13LY_MIN=new BigDecimal("2.00");
    private BigDecimal J13LH_MIN=new BigDecimal("2.00");
    private BigDecimal J13LD_MIN=new BigDecimal("2.00");
    private BigDecimal J13LL_MIN=new BigDecimal("2.00");
    private BigDecimal J13LP_MIN=new BigDecimal("2.00");

    // Joint 3
    private BigDecimal J11RW_MIN=new BigDecimal("2.00");
    private BigDecimal J11RY_MIN=new BigDecimal("2.00");
    private BigDecimal J11RH_MIN=new BigDecimal("2.00");
    private BigDecimal J11RD_MIN=new BigDecimal("2.00");
    private BigDecimal J11RL_MIN=new BigDecimal("2.00");
    private BigDecimal J11RP_MIN=new BigDecimal("2.00");

    private BigDecimal J16LW_MIN=new BigDecimal("2.00");
    private BigDecimal J16LY_MIN=new BigDecimal("2.00");
    private BigDecimal J16LH_MIN=new BigDecimal("2.00");
    private BigDecimal J16LD_MIN=new BigDecimal("2.00");
    private BigDecimal J16LL_MIN=new BigDecimal("2.00");
    private BigDecimal J16LP_MIN=new BigDecimal("2.00");

    // Joint 4
    private BigDecimal J5W_MIN=new BigDecimal("2.00");
    private BigDecimal J5Y_MIN=new BigDecimal("2.00");
    private BigDecimal J5H_MIN=new BigDecimal("2.00");
    private BigDecimal J5D_MIN=new BigDecimal("2.00");
    private BigDecimal J5L_MIN=new BigDecimal("2.00");
    private BigDecimal J5P_MIN=new BigDecimal("2.00");

    // Joint 5
    private BigDecimal J9RW_MIN=new BigDecimal("2.00");
    private BigDecimal J9RY_MIN=new BigDecimal("2.00");
    private BigDecimal J9RH_MIN=new BigDecimal("2.00");
    private BigDecimal J9RD_MIN=new BigDecimal("2.00");
    private BigDecimal J9RL_MIN=new BigDecimal("2.00");
    private BigDecimal J9RP_MIN=new BigDecimal("2.00");

    private BigDecimal J14LW_MIN=new BigDecimal("2.00");
    private BigDecimal J14LY_MIN=new BigDecimal("2.00");
    private BigDecimal J14LH_MIN=new BigDecimal("2.00");
    private BigDecimal J14LD_MIN=new BigDecimal("2.00");
    private BigDecimal J14LL_MIN=new BigDecimal("2.00");
    private BigDecimal J14LP_MIN=new BigDecimal("2.00");

    // Joint 6
    private BigDecimal J6W_MIN=new BigDecimal("2.00");
    private BigDecimal J6Y_MIN=new BigDecimal("2.00");
    private BigDecimal J6H_MIN=new BigDecimal("2.00");
    private BigDecimal J6D_MIN=new BigDecimal("2.00");
    private BigDecimal J6L_MIN=new BigDecimal("2.00");
    private BigDecimal J6P_MIN=new BigDecimal("2.00");

    // Joint 7
    private BigDecimal J2W_MIN=new BigDecimal("2.00");
    private BigDecimal J2Y_MIN=new BigDecimal("2.00");
    private BigDecimal J2H_MIN=new BigDecimal("2.00");
    private BigDecimal J2D_MIN=new BigDecimal("2.00");
    private BigDecimal J2L_MIN=new BigDecimal("2.00");
    private BigDecimal J2P_MIN=new BigDecimal("2.00");

    // Joint 8
    private BigDecimal J10RW_MIN=new BigDecimal("2.00");
    private BigDecimal J10RY_MIN=new BigDecimal("2.00");
    private BigDecimal J10RH_MIN=new BigDecimal("2.00");
    private BigDecimal J10RD_MIN=new BigDecimal("2.00");
    private BigDecimal J10RL_MIN=new BigDecimal("2.00");
    private BigDecimal J10RP_MIN=new BigDecimal("2.00");

    private BigDecimal J15LW_MIN=new BigDecimal("2.00");
    private BigDecimal J15LY_MIN=new BigDecimal("2.00");
    private BigDecimal J15LH_MIN=new BigDecimal("2.00");
    private BigDecimal J15LD_MIN=new BigDecimal("2.00");
    private BigDecimal J15LL_MIN=new BigDecimal("2.00");
    private BigDecimal J15LP_MIN=new BigDecimal("2.00");

    // Joint 9
    private BigDecimal J3W_MIN=new BigDecimal("2.00");
    private BigDecimal J3Y_MIN=new BigDecimal("2.00");
    private BigDecimal J3H_MIN=new BigDecimal("2.00");
    private BigDecimal J3D_MIN=new BigDecimal("2.00");
    private BigDecimal J3L_MIN=new BigDecimal("2.00");
    private BigDecimal J3P_MIN=new BigDecimal("2.00");

    // Joint 1
    private BigDecimal J7RW_MAX= new BigDecimal("5.00");
    private BigDecimal J7RY_MAX= new BigDecimal("5.00");
    private BigDecimal J7RH_MAX= new BigDecimal("5.00");
    private BigDecimal J7RD_MAX= new BigDecimal("5.00");
    private BigDecimal J7RL_MAX= new BigDecimal("5.00");
    private BigDecimal J7RP_MAX= new BigDecimal("5.00");

    private BigDecimal J12LW_MAX= new BigDecimal("5.00");
    private BigDecimal J12LY_MAX= new BigDecimal("5.00");
    private BigDecimal J12LH_MAX= new BigDecimal("5.00");
    private BigDecimal J12LD_MAX= new BigDecimal("5.00");
    private BigDecimal J12LL_MAX= new BigDecimal("5.00");
    private BigDecimal J12LP_MAX= new BigDecimal("5.00");

    // Joint 2
    private BigDecimal J8RW_MAX= new BigDecimal("5.00");
    private BigDecimal J8RY_MAX= new BigDecimal("5.00");
    private BigDecimal J8RH_MAX= new BigDecimal("5.00");
    private BigDecimal J8RD_MAX= new BigDecimal("5.00");
    private BigDecimal J8RL_MAX= new BigDecimal("5.00");
    private BigDecimal J8RP_MAX= new BigDecimal("5.00");

    private BigDecimal J13LW_MAX= new BigDecimal("5.00");
    private BigDecimal J13LY_MAX= new BigDecimal("5.00");
    private BigDecimal J13LH_MAX= new BigDecimal("5.00");
    private BigDecimal J13LD_MAX= new BigDecimal("5.00");
    private BigDecimal J13LL_MAX= new BigDecimal("5.00");
    private BigDecimal J13LP_MAX= new BigDecimal("5.00");

    // Joint 3
    private BigDecimal J11RW_MAX= new BigDecimal("5.00");
    private BigDecimal J11RY_MAX= new BigDecimal("5.00");
    private BigDecimal J11RH_MAX= new BigDecimal("5.00");
    private BigDecimal J11RD_MAX= new BigDecimal("5.00");
    private BigDecimal J11RL_MAX= new BigDecimal("5.00");
    private BigDecimal J11RP_MAX= new BigDecimal("5.00");

    private BigDecimal J16LW_MAX= new BigDecimal("5.00");
    private BigDecimal J16LY_MAX= new BigDecimal("5.00");
    private BigDecimal J16LH_MAX= new BigDecimal("5.00");
    private BigDecimal J16LD_MAX= new BigDecimal("5.00");
    private BigDecimal J16LL_MAX= new BigDecimal("5.00");
    private BigDecimal J16LP_MAX= new BigDecimal("5.00");

    // Joint 4
    private BigDecimal J5W_MAX= new BigDecimal("5.00");
    private BigDecimal J5Y_MAX= new BigDecimal("5.00");
    private BigDecimal J5H_MAX= new BigDecimal("5.00");
    private BigDecimal J5D_MAX= new BigDecimal("5.00");
    private BigDecimal J5L_MAX= new BigDecimal("5.00");
    private BigDecimal J5P_MAX= new BigDecimal("5.00");

    // Joint 5
    private BigDecimal J9RW_MAX= new BigDecimal("5.00");
    private BigDecimal J9RY_MAX= new BigDecimal("5.00");
    private BigDecimal J9RH_MAX= new BigDecimal("5.00");
    private BigDecimal J9RD_MAX= new BigDecimal("5.00");
    private BigDecimal J9RL_MAX= new BigDecimal("5.00");
    private BigDecimal J9RP_MAX= new BigDecimal("5.00");

    private BigDecimal J14LW_MAX= new BigDecimal("5.00");
    private BigDecimal J14LY_MAX= new BigDecimal("5.00");
    private BigDecimal J14LH_MAX= new BigDecimal("5.00");
    private BigDecimal J14LD_MAX= new BigDecimal("5.00");
    private BigDecimal J14LL_MAX= new BigDecimal("5.00");
    private BigDecimal J14LP_MAX= new BigDecimal("5.00");

    // Joint 6
    private BigDecimal J6W_MAX= new BigDecimal("5.00");
    private BigDecimal J6Y_MAX= new BigDecimal("5.00");
    private BigDecimal J6H_MAX= new BigDecimal("5.00");
    private BigDecimal J6D_MAX= new BigDecimal("5.00");
    private BigDecimal J6L_MAX= new BigDecimal("5.00");
    private BigDecimal J6P_MAX= new BigDecimal("5.00");

    // Joint 7
    private BigDecimal J2W_MAX= new BigDecimal("5.00");
    private BigDecimal J2Y_MAX= new BigDecimal("5.00");
    private BigDecimal J2H_MAX= new BigDecimal("5.00");
    private BigDecimal J2D_MAX= new BigDecimal("5.00");
    private BigDecimal J2L_MAX= new BigDecimal("5.00");
    private BigDecimal J2P_MAX= new BigDecimal("5.00");

    // Joint 8
    private BigDecimal J10RW_MAX= new BigDecimal("5.00");
    private BigDecimal J10RY_MAX= new BigDecimal("5.00");
    private BigDecimal J10RH_MAX= new BigDecimal("5.00");
    private BigDecimal J10RD_MAX= new BigDecimal("5.00");
    private BigDecimal J10RL_MAX= new BigDecimal("5.00");
    private BigDecimal J10RP_MAX= new BigDecimal("5.00");

    private BigDecimal J15LW_MAX= new BigDecimal("5.00");
    private BigDecimal J15LY_MAX= new BigDecimal("5.00");
    private BigDecimal J15LH_MAX= new BigDecimal("5.00");
    private BigDecimal J15LD_MAX= new BigDecimal("5.00");
    private BigDecimal J15LL_MAX= new BigDecimal("5.00");
    private BigDecimal J15LP_MAX= new BigDecimal("5.00");

    // Joint 9
    private BigDecimal J3W_MAX= new BigDecimal("5.00");
    private BigDecimal J3Y_MAX= new BigDecimal("5.00");
    private BigDecimal J3H_MAX= new BigDecimal("5.00");
    private BigDecimal J3D_MAX= new BigDecimal("5.00");
    private BigDecimal J3L_MAX= new BigDecimal("5.00");
    private BigDecimal J3P_MAX= new BigDecimal("5.00");


}

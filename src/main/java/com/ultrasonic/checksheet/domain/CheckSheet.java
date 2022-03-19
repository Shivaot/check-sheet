package com.ultrasonic.checksheet.domain;

import com.ultrasonic.checksheet.enums.IE;
import com.ultrasonic.checksheet.enums.OkNotOk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Shiva Created on 05/03/22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateCreated = new Date(System.currentTimeMillis());

    // Joint 1
    private BigDecimal J7R_Theta;
    private BigDecimal J7RW;
    private BigDecimal J7RY;
    private BigDecimal J7RH;
    private BigDecimal J7RD;
    private BigDecimal J7RL;
    private BigDecimal J7RP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J7R_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J7R_IE;
    private String J7R_Weldor;

    private BigDecimal J12L_Theta;
    private BigDecimal J12LW;
    private BigDecimal J12LY;
    private BigDecimal J12LH;
    private BigDecimal J12LD;
    private BigDecimal J12LL;
    private BigDecimal J12LP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J12L_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J12L_IE;
    private String J12L_Weldor;

    // Joint 2
    private BigDecimal J8R_Theta;
    private BigDecimal J8RW;
    private BigDecimal J8RY;
    private BigDecimal J8RH;
    private BigDecimal J8RD;
    private BigDecimal J8RL;
    private BigDecimal J8RP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J8R_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J8R_IE;
    private String J8R_Weldor;

    private BigDecimal J13L_Theta;
    private BigDecimal J13LW;
    private BigDecimal J13LY;
    private BigDecimal J13LH;
    private BigDecimal J13LD;
    private BigDecimal J13LL;
    private BigDecimal J13LP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J13L_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J13L_IE;
    private String J13L_Weldor;

    // Joint 3
    private BigDecimal J11R_Theta;
    private BigDecimal J11RW;
    private BigDecimal J11RY;
    private BigDecimal J11RH;
    private BigDecimal J11RD;
    private BigDecimal J11RL;
    private BigDecimal J11RP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J11R_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J11R_IE;
    private String J11R_Weldor;

    private BigDecimal J16L_Theta;
    private BigDecimal J16LW;
    private BigDecimal J16LY;
    private BigDecimal J16LH;
    private BigDecimal J16LD;
    private BigDecimal J16LL;
    private BigDecimal J16LP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J16L_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J16L_IE;
    private String J16L_Weldor;

    // Joint 4
    private BigDecimal J5_Theta;
    private BigDecimal J5W;
    private BigDecimal J5Y;
    private BigDecimal J5H;
    private BigDecimal J5D;
    private BigDecimal J5L;
    private BigDecimal J5P;
    @Enumerated(EnumType.STRING)
    private OkNotOk J5_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J5_IE;
    private String J5_Weldor;

    // Joint 5
    private BigDecimal J9R_Theta;
    private BigDecimal J9RW;
    private BigDecimal J9RY;
    private BigDecimal J9RH;
    private BigDecimal J9RD;
    private BigDecimal J9RL;
    private BigDecimal J9RP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J9R_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J9R_IE;
    private String J9R_Weldor;

    private BigDecimal J14L_Theta;
    private BigDecimal J14LW;
    private BigDecimal J14LY;
    private BigDecimal J14LH;
    private BigDecimal J14LD;
    private BigDecimal J14LL;
    private BigDecimal J14LP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J14L_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J14L_IE;
    private String J14L_Weldor;

    // Joint 6
    private BigDecimal J6_Theta;
    private BigDecimal J6W;
    private BigDecimal J6Y;
    private BigDecimal J6H;
    private BigDecimal J6D;
    private BigDecimal J6L;
    private BigDecimal J6P;
    @Enumerated(EnumType.STRING)
    private OkNotOk J6_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J6_IE;
    private String J6_Weldor;

    // Joint 7
    private BigDecimal J2_Theta;
    private BigDecimal J2W;
    private BigDecimal J2Y;
    private BigDecimal J2H;
    private BigDecimal J2D;
    private BigDecimal J2L;
    private BigDecimal J2P;
    @Enumerated(EnumType.STRING)
    private OkNotOk J2_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J2_IE;
    private String J2_Weldor;

    // Joint 8
    private BigDecimal J10R_Theta;
    private BigDecimal J10RW;
    private BigDecimal J10RY;
    private BigDecimal J10RH;
    private BigDecimal J10RD;
    private BigDecimal J10RL;
    private BigDecimal J10RP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J10R_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J10R_IE;
    private String J10R_Weldor;

    private BigDecimal J15L_Theta;
    private BigDecimal J15LW;
    private BigDecimal J15LY;
    private BigDecimal J15LH;
    private BigDecimal J15LD;
    private BigDecimal J15LL;
    private BigDecimal J15LP;
    @Enumerated(EnumType.STRING)
    private OkNotOk J15L_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J15L_IE;
    private String J15L_Weldor;

    // Joint 9
    private BigDecimal J3_Theta;
    private BigDecimal J3W;
    private BigDecimal J3Y;
    private BigDecimal J3H;
    private BigDecimal J3D;
    private BigDecimal J3L;
    private BigDecimal J3P;
    @Enumerated(EnumType.STRING)
    private OkNotOk J3_JUDGEMENT;
    @Enumerated(EnumType.STRING)
    private IE J3_IE;
    private String J3_Weldor;

    private String model;
    private String partName;
    private String partNumber;
    private String punchNumber;
    private String CHUB;
    private String FHUB;
    private String inspector;

    private Boolean isCurrentRevision;

}

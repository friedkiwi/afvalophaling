package gent.gouvernementstraat.afvalophaling.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;
import gent.gouvernementstraat.afvalophaling.models.Ophaaldag;
import gent.gouvernementstraat.afvalophaling.models.Ophaling;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class IndexAction extends ActionSupport {
    private LocalDateTime glasDagStart = LocalDateTime.of(2022,02,04,1,1);
    private LocalDateTime papierDagStart = LocalDateTime.of(2022,02,1,1,1);

    private LocalDateTime pmdDagStart = LocalDateTime.of(2022,05,24, 1,1);

    private static final Logger logger = LogManager.getLogger(IndexAction.class);
    public String execute() {
        return SUCCESS;
    }

    private boolean isRestafvaldag(LocalDate dag) {
        if (dag.getDayOfWeek() == DayOfWeek.TUESDAY || dag.getDayOfWeek() == DayOfWeek.FRIDAY)
            return true;
        return false;
    }

    private boolean isTweewekelijkseDag(LocalDate dag, LocalDateTime startpunt, DayOfWeek shortcutDag) {
        // shortcut
        if (dag.getDayOfWeek() != shortcutDag)
            return false;

        LocalDate tweewekelijkseDagWork = LocalDate.from(startpunt);
        // get next glasdag
        while (tweewekelijkseDagWork.toEpochDay() < dag.toEpochDay()) {
            tweewekelijkseDagWork = tweewekelijkseDagWork.plusDays(14);
        }

        if (tweewekelijkseDagWork.isEqual(dag))
            return true;

        return false;
    }

    private boolean isGlasdag(LocalDate dag) {
        return isTweewekelijkseDag(dag, glasDagStart, DayOfWeek.FRIDAY);
    }

    private  boolean isPapierdag(LocalDate dag) {
        return isTweewekelijkseDag(dag, papierDagStart, DayOfWeek.TUESDAY);
    }

    private boolean isPMDdag(LocalDate dag) {
        return isTweewekelijkseDag(dag, pmdDagStart, DayOfWeek.TUESDAY);
    }

    public List getOphaaldagen() {
        ArrayList<Ophaaldag> ophaaldagen = new ArrayList<>();

        LocalDate workDate = LocalDate.now();
        for (int i = 0; i < 35; i++) {
            Ophaaldag ophaaldag = new Ophaaldag(workDate.atStartOfDay());
            if (isRestafvaldag(workDate))
                ophaaldag.addOphaling(Ophaling.REST);
            if (isGlasdag(workDate))
                ophaaldag.addOphaling(Ophaling.GLAS);
            if (isPapierdag(workDate))
                ophaaldag.addOphaling(Ophaling.PAPIER);
            if (isPMDdag(workDate))
                ophaaldag.addOphaling(Ophaling.PMD);
            if (ophaaldag.hasOphalingen())
                ophaaldagen.add(ophaaldag);
            workDate = workDate.plusDays(1);
        }

        return ophaaldagen;
    }
}

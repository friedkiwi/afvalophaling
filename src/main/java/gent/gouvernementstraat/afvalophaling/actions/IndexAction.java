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

    private static final Logger logger = LogManager.getLogger(IndexAction.class);
    public String execute() {
        return SUCCESS;
    }

    private boolean isRestafvaldag(LocalDate dag) {
        if (dag.getDayOfWeek() == DayOfWeek.TUESDAY || dag.getDayOfWeek() == DayOfWeek.FRIDAY)
            return true;
        return false;
    }

    private boolean isGlasdag(LocalDate dag) {
        // shortcut
        if (dag.getDayOfWeek() != DayOfWeek.FRIDAY)
            return false;

        LocalDate glasDagWork = LocalDate.from(glasDagStart);
        // get next glasdag
        while (glasDagWork.toEpochDay() < dag.toEpochDay()) {
            glasDagWork = glasDagWork.plusDays(14);
        }

        if (glasDagWork.isEqual(dag))
            return true;

        return false;
    }

    private  boolean isPapierdag(LocalDate dag) {
        // shortcut
        if (dag.getDayOfWeek() != DayOfWeek.TUESDAY)
            return false;

        LocalDate papierDagWork = LocalDate.from(papierDagStart);
        // get next glasdag
        while (papierDagWork.toEpochDay() < dag.toEpochDay()) {
            papierDagWork = papierDagWork.plusDays(14);
        }


        if (papierDagWork.isEqual(dag))
            return true;

        return false;
    }

    public List getOphaaldagen() {
        ArrayList<Ophaaldag> ophaaldagen = new ArrayList<>();

        LocalDate workDate = LocalDate.now();
        for (int i = 0; i < 40; i++) {
            Ophaaldag ophaaldag = new Ophaaldag(workDate.atStartOfDay());
            if (isRestafvaldag(workDate))
                ophaaldag.addOphaling(Ophaling.REST);
            if (isGlasdag(workDate))
                ophaaldag.addOphaling(Ophaling.GLAS);
            if (isPapierdag(workDate))
                ophaaldag.addOphaling(Ophaling.PAPIER);
            if (ophaaldag.hasOphalingen())
                ophaaldagen.add(ophaaldag);
            workDate = workDate.plusDays(1);
        }

        return ophaaldagen;
    }
}

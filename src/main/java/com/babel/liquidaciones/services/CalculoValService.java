package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.model.Siniestro;
import com.babel.liquidaciones.services.interfaces.ICalculoValService;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CalculoValService implements ICalculoValService {

    private Siniestro siniestro;

    public CalculoValService(Siniestro siniestro){
        this.siniestro = siniestro;
    }

    @Override
    public Double calcularPrimerRiesgo(Damage daño) {
        Double capitalInsured = daño.getWarranty().getCapitalInsured();

        Double liquidacionASumar = Math.min(capitalInsured, this.siniestro.getPolizaAsociada().getImporteCapitalesContratados());
        return liquidacionASumar;
    }

    @Override
    public Double calcularReposicion(Damage daño) {
        return daño.getWarranty().getCapitalInsured();
    }

    @Override
    public Double calcularValorReal(Damage daño) {
        double capitalInsured = daño.getWarranty().getCapitalInsured();
        double depreciacion = 100/7;

        Calendar calFecha1 = Calendar.getInstance();
        calFecha1.setTime(daño.getAntiguedad());
        Calendar calFecha2 = Calendar.getInstance();
        calFecha2.setTime(siniestro.getFechaDeOcurrencia());

        double antiguedad = calFecha2.get(Calendar.YEAR) - calFecha1.get(Calendar.YEAR);

        double valResidual = capitalInsured * 0.1;
        double total = capitalInsured * antiguedad * depreciacion;

        return Math.max(valResidual,total);
    }
}

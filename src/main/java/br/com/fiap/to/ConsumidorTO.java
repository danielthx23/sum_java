package br.com.fiap.to;

import java.sql.Timestamp;

public class ConsumidorTO {
    private long consumidorId;                // consumidorId: long (ID of the consumer)
    private String classeDeConsumo;           // classeDeConsumo: String (Class of consumption, e.g., "Residential", "Commercial")
    private String tipoDeConsumo;             // tipoDeConsumo: String (Type of consumption, e.g., "Electricity", "Gas")
    private float consumoEnergetico;          // consumoEnergetico: float (Total energy consumption in kWh or other units)
    private String numeroDoMedidor;           // numeroDoMedidor: String (Meter number associated with the consumer)
    private float tarifa;                     // tarifa: float (Tariff rate per unit of consumption)
    private float consumoDeEnergiaMes;        // consumoDeEnergiaMes: float (Energy consumption for the current month in kWh)
    private Timestamp ultimaDataDeLeitura;    // ultimaDataDeLeitura: Timestamp (Date of the last meter reading)
    private UsuarioTO usuario;
}

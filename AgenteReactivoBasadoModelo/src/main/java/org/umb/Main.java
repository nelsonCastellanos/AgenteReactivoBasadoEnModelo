package org.umb;

import aima.core.environment.vacuum.ModelBasedReflexVacuumAgent;
import aima.core.environment.vacuum.VacuumEnvironment;
import aima.core.environment.vacuum.VacuumEnvironmentViewActionTracker;

public class Main {

  public static void main(String[] args) throws Exception {
    // Se utilizará para realizar un seguimiento de los cambios en el entorno.
    StringBuilder envChanges = new StringBuilder();

    // Agente aspiradora de tipo reactivo basado en el modelo. Este agente utiliza un modelo interno del entorno para tomar decisiones.
    ModelBasedReflexVacuumAgent agent = new ModelBasedReflexVacuumAgent();

    // Representa el entorno de aspirado. Se inicializan las ubicaciones A y B con suciedad
    VacuumEnvironment environment = new VacuumEnvironment(
        VacuumEnvironment.LocationState.Dirty,
        VacuumEnvironment.LocationState.Dirty);

    // El agente estará presente en la ubicación A del entorno.
    environment.addAgent(agent, VacuumEnvironment.LOCATION_A);

    // Rastreará las acciones realizadas por el agente y las almacenará en el StringBuilder envChanges.
    environment.addEnvironmentView(new
        VacuumEnvironmentViewActionTracker(envChanges));

    // Esto ejecutará el entorno hasta que se hayan realizado todas las acciones necesarias para limpiar las ubicaciones A y B.
    environment.stepUntilDone();

    // imprime en la consola el historial de acciones realizadas por el agente
    System.out.println("Actions: " + envChanges);
  }
}

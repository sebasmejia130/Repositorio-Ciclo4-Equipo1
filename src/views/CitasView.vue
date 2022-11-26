<template>
    <div class="container">
        <div class="card-header-flex">
            <h3>Citas</h3>
            <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#registerModal">Insertar</button>
        </div>
        <div class="car-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>IDENTIFICACION</th>
                        <th>TIPO</th>
                        <th>LUGAR</th>
                        <th>FECHA</th>
                        <th>PACIENTE</th>
                        <th>MEDICO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="cita in citas">
                        <td>{{ cita.id }}</td>
                        <td>{{ cita.tipoExamen }}</td>
                        <td>{{ cita.lugarProcedimiento }}</td>
                        <td>{{ cita.fechaProcedimiento }}</td>
                        <td>{{ cita.paciente }}</td>
                        <td>{{ cita.idMedicoGeneral }}</td>
                        <td>
                            <div class="buttons-acciones">
                                <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                    data-bs-target="#editarModal">
                                    <img src="../assets/svg/edit.svg" alt="">
                                </button>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#eliminarModal">
                                    <img src="../assets/svg/delete.svg" alt="">
                                </button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <CrearCitaModal @cita-creada="consultaCitas"/>
</template>

<script>
import CrearCitaModal from '../components/Cita/CrearCitaModal.vue';


export default {
    data() {
        return {
            titulo: "TuCita.com",
            citas: []
        };
    },
    methods: {
        async consultaCitas() {
            const opciones = {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkMWQ2NjA3MS1jZTljLTQ5YjktOTJhNy0xM2E1MjUzNDQwMTY="
                }
            };
            fetch("http://localhost:8080/api/ordenes", opciones)
                .then(async (response) => {
                if (!response.ok) {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
                else {
                    this.citas = await response.json();
                    console.log(this.citas);
                    console.log(this.citas.length);
                    // console.log(this.citas[0].nombrePaciente);
                }
            });
        }
    },
    beforeMount() {
        this.consultaCitas();
    },
    components: { CrearCitaModal }
}
</script>

<style scoped>
.buttons-acciones {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 5px;
}

.buttons-acciones button {
    display: flex;
    justify-content: center;
    align-items: center;
}

.card-header-flex {
    margin: 10px 50px;
    display: grid;
    grid-template-columns: 70% 30%;
}

.car-body {
    margin: 20px 100px;
    font-size: 12px;
}

.car-body th {
    font-weight: 900;
}

#editarModal {
    display: flexbox;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
</style>
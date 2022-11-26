<template>
    <div class="container">
        <div class="card-header-flex">
            <h3>Doctores</h3>
            <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#registerModal">Insertar</button>
        </div>
        <div class="car-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>PRIMER APELLIDO</th>
                        <th>SEGUNDO APELLIDO</th>
                        <th>TELEFONO</th>
                        <th>AREA</th>
                        <th>REMISION</th>
                        <th>USUARIO</th>
                        <th>CONTRASEÑA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="doctor in doctores">
                        <td>{{doctor.id}}</td>
                        <td>{{doctor.nombreMedico}}</td>
                        <td>{{doctor.apellidoPaternoMedico}}</td>
                        <td>{{doctor.apellidoMaternoMedico}}</td>
                        <td>{{doctor.telefonoMedico}}</td>
                        <td>{{doctor.areaMedico}}</td>
                        <td>{{doctor.remision}}</td>
                        <td>{{doctor.usuarioMedico}}</td>
                        <td>*********</td>
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
    <CrearMedicoModal @medico-creado="consultaDoctores"/>
</template>

<script>
import CrearMedicoModal from '../components/Medico/CrearMedicoModal.vue';

export default {
    data() {
        return {
            titulo: "TuCita.com",
            doctores: []
        };
    },
    methods: {
        async consultaDoctores() {
            const opciones = {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkMWQ2NjA3MS1jZTljLTQ5YjktOTJhNy0xM2E1MjUzNDQwMTY="
                }
            };
            fetch("http://localhost:8080/api/medico", opciones)
                .then(async (response) => {
                if (!response.ok) {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
                else {
                    this.doctores = await response.json();
                    console.log(this.doctores);
                    console.log(this.doctores.length);
                    // console.log(this.citas[0].nombrePaciente);
                }
            });
        }
    },
    beforeMount() {
        this.consultaDoctores();
    },
    components: { CrearMedicoModal }
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
    font-weight: 700;
}

#editarModal {
    display: flexbox;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
</style>
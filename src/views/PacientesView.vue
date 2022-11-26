<template>
    <div class="container">
        <div class="card-header-flex">
            <h3>Pacientes</h3>
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
                        <th>EMAIL</th>
                        <th>FECHA DE NACIMIENTO</th>
                        <th>GENERO</th>
                        <th>CIUDAD</th>
                        <th>DIRECCION</th>
                        <th>CODIGO</th>
                        <th>USUARIO</th>
                        <th>CONTRASEÑA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="paciente in pacientes">
                        <EliminarPacienteModal :paciente="paciente" />
                        <td>{{ paciente.id }}</td>
                        <td>{{ paciente.nombrePaciente }}</td>
                        <td>{{ paciente.apellidoPaternoPaciente }}</td>
                        <td>{{ paciente.apellidoMaternoPaciente }}</td>
                        <td>{{ paciente.telefonoPaciente }}</td>
                        <td>{{ paciente.emailPaciente }}</td>
                        <td>{{ paciente.fechaNacimientoPaciente }}</td>
                        <td>{{ paciente.generoPaciente }}</td>
                        <td>{{ paciente.ciudadResidenciaPaciente }}</td>
                        <td>{{ paciente.direccionResidenciaPaciente }}</td>
                        <td>{{ paciente.codigoAfiliacionPaciente }}</td>
                        <td>{{ paciente.usuarioPaciente }}</td>
                        <td>*********</td>
                        <td>
                            <!-- <div class="buttons-acciones">
                                <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                    data-bs-target="#editarModal">
                                    <img src="../assets/svg/edit.svg" alt="">
                                </button>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#eliminarModal">
                                    <img src="../assets/svg/delete.svg" alt="">
                                </button>
                            </div> -->
                            <div class="buttons-acciones">
                                <button type="button" class="btn btn-warning">
                                    <img src="../assets/svg/edit.svg" alt="">
                                </button>
                                <button type="button" class="btn btn-primary" @click="eliminarPaciente(paciente.id)">
                                    <img src="../assets/svg/delete.svg" alt="">
                                </button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <CrearPacienteModal @paciente-creado="consultaPacientes"/>
</template>

<script>
import CrearPacienteModal from '../components/Paciante/CrearPacienteModal.vue';
import EliminarPacienteModal from '../components/Paciante/EliminarPacienteModal.vue';

export default {
    props: {
        paciente: {
            type: Object
        }
    },
    data() {
        return {
            titulo: "TuCita.com",
            pacientes: []
        };
    },
    methods: {
        async consultaPacientes() {
            const opciones = {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkZTAzMDgyNy0yZTI5LTQxMGUtYTgxNi0zMzUzMjlhNWU5YzI="
                }
            };
            fetch("http://localhost:8080/api/pacientes", opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        console.log(error.message);
                        throw error;
                    }
                    else {
                        this.pacientes = await response.json();
                        console.log(this.pacientes);
                        console.log(this.pacientes.length);
                        // console.log(this.pacientes[0].nombrePaciente);
                    }
                });
        },
        async crearPaciente() {
            const opciones = {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkMWQ2NjA3MS1jZTljLTQ5YjktOTJhNy0xM2E1MjUzNDQwMTY="
                },
                body: JSON.stringify({
                    id: this.id,
                    nombrePaciente: this.nombrePaciente,
                    estado: this.estado
                })
            };
            fetch("http://localhost:8080/api/pacientes", opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        throw error;
                    }
                    else {
                        const data = await response.json();
                        console.log(data);
                    }
                });
        },
        async eliminarPaciente(id) {
            const opciones = {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkZTAzMDgyNy0yZTI5LTQxMGUtYTgxNi0zMzUzMjlhNWU5YzI="
                }
            };
            fetch(`http://localhost:8080/api/pacientes/d/${id}`, opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        throw error;
                    }
                    else {
                        const data = await response.json();
                        console.log(data);
                        alert("Hola")
                        console.log(consultaPacientes());
                    }
                });
        }
    },
    beforeMount() {
        this.consultaPacientes();
    },
    components: { CrearPacienteModal, EliminarPacienteModal }
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
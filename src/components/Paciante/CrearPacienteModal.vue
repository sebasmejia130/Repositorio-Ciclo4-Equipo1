<template>
    <!-- Modal - Register -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content container">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Editar paciente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                    </button>
                </div>
                <div class="modal-body">
                    <form class="row g-4 container-fr">
                        <div class="col-md-6">
                            <label for="id">Id</label>
                            <input v-model="id" type="number" class="form-control" id="id" name="id">
                        </div>
                        <div class="col-md-6">
                            <label for="nombres">Nombres</label>
                            <input v-model="nombrePaciente" type="text" class="form-control" id="nombres"
                                name="descripcion">
                        </div>
                        <div class="col-md-6">
                            <label for="primerApellido">Primer apellido</label>
                            <input v-model="apellidoPaternoPaciente" type="text" class="form-control"
                                id="primerApellido" name="primerApellido">
                        </div>
                        <div class="col-md-6">
                            <label for="segundoApellido">Segundo apellido</label>
                            <input v-model="apellidoMaternoPaciente" type="text" class="form-control"
                                id="segundoApellido" name="segundoApellido">
                        </div>
                        <div class="col-md-6">
                            <label for="telefono">Telefono</label>
                            <input v-model="telefonoPaciente" type="number" class="form-control" id="telefono"
                                name="telefono">
                        </div>
                        <div class="col-md-6">
                            <label for="correo">Correo electronico</label>
                            <input v-model="emailPaciente" type="text" class="form-control" id="correo" name="correo">
                        </div>
                        <div class="col-md-6">
                            <label for="fechaNacimiento">Fecha de nacimiento</label>
                            <input v-model="fechaNacimientoPaciente" type="date" class="form-control"
                                id="fechaNacimiento" name="fechaNacimiento">
                        </div>
                        <div class="col-md-6">
                            <label for="genero">Genero</label>
                            <input v-model="generoPaciente" type="text" class="form-control" id="genero" name="genero">
                        </div>
                        <div class="col-md-6">
                            <label for="ciudad">Ciudad</label>
                            <input v-model="ciudadResidenciaPaciente" type="text" class="form-control" id="ciudad"
                                name="ciudad">
                        </div>
                        <div class="col-md-6">
                            <label for="direci??n">Direcci??n</label>
                            <input v-model="direccionResidenciaPaciente" type="text" class="form-control" id="direci??n"
                                name="direci??n">
                        </div>
                        <div class="col-md-6">
                            <label for="codigoAfiliacion">Codigo de afiliaci??n</label>
                            <input v-model="codigoAfiliacionPaciente" type="number" class="form-control"
                                id="direcodigoAfiliacionci??n" name="codigoAfiliacion">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Usuario</label>
                            <input v-model="usuarioPaciente" type="text" class="form-control" id="usuario"
                                name="usuario">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Contrase??a</label>
                            <input v-model="contrase??aPaciente" type="password" class="form-control" id="contrase??a"
                                name="contrase??a">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Confirmar contrase??a</label>
                            <input v-model="contrase??aTemporal" type="password" class="form-control"
                                id="contrase??aTemporal" name="contrase??aTemporal">
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button @click="validarPaiente()" class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    
    data() {
        return {
            titulo: "TuCita.com",
            pacientes: [],
            id: null,
            nombrePaciente: '',
            apellidoPaternoPaciente: '',
            apellidoMaternoPaciente: '',
            telefonoPaciente: null,
            emailPaciente: '',
            fechaNacimientoPaciente: '',
            generoPaciente: '',
            ciudadResidenciaPaciente: '',
            direccionResidenciaPaciente: '',
            codigoAfiliacionPaciente: null,
            usuarioPaciente: '',
            contrase??aPaciente: '',
            contrase??aTemporal: ''
        };
    },
    methods: {
        limpiarForm(){
            this.id = null,
            this.nombrePaciente = '',
            this.apellidoPaternoPaciente = '',
            this.apellidoMaternoPaciente = '',
            this.telefonoPaciente = null,
            this.emailPaciente = '',
            this.fechaNacimientoPaciente = '',
            this.generoPaciente = '',
            this.ciudadResidenciaPaciente = '',
            this.direccionResidenciaPaciente = '',
            this.codigoAfiliacionPaciente = null,
            this.usuarioPaciente = '',
            this.contrase??aPaciente = '',
            this.contrase??aTemporal = ''
        },
        async crearPaciente() {
            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkZTAzMDgyNy0yZTI5LTQxMGUtYTgxNi0zMzUzMjlhNWU5YzI="
                },
                body: JSON.stringify({
                    id: this.id,
                    nombrePaciente: this.nombrePaciente,
                    apellidoPaternoPaciente: this.apellidoPaternoPaciente,
                    apellidoMaternoPaciente: this.apellidoMaternoPaciente,
                    telefonoPaciente: this.telefonoPaciente,
                    emailPaciente: this.emailPaciente,
                    fechaNacimientoPaciente: this.fechaNacimientoPaciente,
                    generoPaciente: this.generoPaciente,
                    ciudadResidenciaPaciente: this.ciudadResidenciaPaciente,
                    direccionResidenciaPaciente: this.direccionResidenciaPaciente,
                    codigoAfiliacionPaciente: this.codigoAfiliacionPaciente,
                    usuarioPaciente: this.usuarioPaciente,
                    contrase??aPaciente: this.contrase??aPaciente
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
                        this.limpiarForm();
                        this.$emit('paciente-creado');
                    }
                });
        },
        validarPaiente(){
            if (this.contrase??aPaciente == this.contrase??aTemporal) {
                this.crearPaciente();
            } else {
                alert('Las contrase??as no conciden');
            }
        },
        recargar(){
            this.PacientesView.consultaPacientes();
        }
    }
}
</script>

<style scoped>
.container-fr {
    padding: 10px 30px 30px 30px;
}
</style>
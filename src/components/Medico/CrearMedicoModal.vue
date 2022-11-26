<template>
    <!-- Modal - Register -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content container">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Editar doctor</h5>
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
                            <input v-model="nombreMedico" type="text" class="form-control" id="nombres"
                                name="descripcion">
                        </div>
                        <div class="col-md-6">
                            <label for="primerApellido">Primer apellido</label>
                            <input v-model="apellidoPaternoMedico" type="text" class="form-control"
                                id="primerApellido" name="primerApellido">
                        </div>
                        <div class="col-md-6">
                            <label for="segundoApellido">Segundo apellido</label>
                            <input v-model="apellidoMaternoMedico" type="text" class="form-control"
                                id="segundoApellido" name="segundoApellido">
                        </div>
                        <div class="col-md-6">
                            <label for="telefono">Telefono</label>
                            <input v-model="telefonoMedico" type="number" class="form-control" id="telefono"
                                name="telefono">
                        </div>
                        <div class="col-md-6">
                            <label for="area">Area</label>
                            <input v-model="areaMedico" type="text" class="form-control" id="area" name="area">
                        </div>
                        <div class="col-md-6">
                            <label for="remision">Remisión</label>
                            <input v-model="remision" type="text" class="form-control"
                                id="remision" name="remision">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Usuario</label>
                            <input v-model="usuarioMedico" type="text" class="form-control" id="usuario"
                                name="usuario">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Contraseña</label>
                            <input v-model="contraseñaMedico" type="password" class="form-control" id="contraseña"
                                name="contraseña">
                        </div>
                        <div class="col-md-6">
                            <label for="usuario">Confirmar contraseña</label>
                            <input v-model="contraseñaTemporal" type="password" class="form-control"
                                id="contraseñaTemporal" name="contraseñaTemporal">
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button @click="validarMedico()" class="btn btn-primary">Guardar</button>
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
            medicos: [],
            id: null,
            nombreMedico: '',
            apellidoPaternoMedico: '',
            apellidoMaternoMedico: '',
            telefonoMedico: null,
            areaMedico: '',
            remision: '',
            usuarioMedico: '',
            contraseñaMedico: '',
            contraseñaTemporal: ''
        };
    },
    methods: {
        limpiarForm(){
            this.id = null,
            this.nombreMedico = '',
            this.apellidoPaternoMedico = '',
            this.apellidoMaternoMedico = '',
            this.telefonoMedico = null,
            this.areaMedico = '',
            this.remision = '',
            this.usuarioMedico = '',
            this.contraseñaMedico = '',
            this.contraseñaTemporal = ''
        },
        async crearMedico() {
            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjplYzNmNjIxZi03YWIxLTQxZDctODJmNi1iZjY4ZjZiMDVmZTE="
                },
                body: JSON.stringify({
                    id: this.id,
                    nombreMedico: this.nombreMedico,
                    apellidoPaternoMedico: this.apellidoPaternoMedico,
                    apellidoMaternoMedico: this.apellidoMaternoMedico,
                    telefonoMedico: this.telefonoMedico,
                    areaMedico: this.areaMedico,
                    remision: this.remision,
                    usuarioMedico: this.usuarioMedico,
                    contraseñaMedico: this.contraseñaMedico,
                    contraseñaTemporal: this.contraseñaTemporal
                })
            };
            fetch("http://localhost:8080/api/medico", opciones)
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
                        this.$emit('medico-creado');
                    }
                });
        },
        validarMedico(){
            if (this.contraseñaMedico == this.contraseñaTemporal) {
                this.crearMedico();
            } else {
                alert('Las contraseñas no conciden');
            }
        }
    }
}
</script>

<style scoped>
.container-fr {
    padding: 10px 30px 30px 30px;
}
</style>
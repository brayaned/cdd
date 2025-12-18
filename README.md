# cdd

Lista url SIAR (CDD): 

 { path: "catalogos", component: ConfiguracionCatalogosComponent }, 
  { path: "riesgo", component: ConfiguracionRiesgoComponent },
  { path: "variables-riesgo", component: ConfiguracionvariablesComponent },
  { path: "riesgo-total", component: ConfiguraciontotalComponent },
  { path: "resultado-riesgo", component: ConfiguracionPersonasComponent },

http://localhost:4200/#/

1.
URL: /catalogos  
// Tabla CDDLAFT_INDICE_CATALOGOS
GET
catalogos: {'Industria': { 
// Tabla CDDLAFT_PERFIL_RIESGO_INDUSTRIA
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Ocupación': {
//Tabla CDDLAFT_PERFIL_RIESGO_OCUPACION
	data: {
		0:{
//Observación: el id debe ser string para poder manejar la estructura, la cual debe ser del siguiente modo:
Código  Descripción
EMP 	EMPLEADO
REN 	RENTISTA
PEN 	PENSIONADO
IND 	IDEPENDIENTE
DES 	DESEMPLEADO
EST 	ESTUDIANTE
Definido por el usuario, si se requiere uno nuevo debe ser agregado manualmente pero principalmente se maneja esta estructura.

    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Productos': {
//Tabla CDDLAFT_PERFIL_RIESGO_PRODUCTO
	data: {
//Tipos de datos recibidos para el campo producto id:
Código  Descripción
PRO 	Prospera
FIN 	Financing
BIZ 	Bizagi Banco
CDT 	CDT
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Pais': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS
	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Canal de Onboarding': {
// Tabla CDDLAFT_PERFIL_RIESGO_CANAL_ONBOARDING
	data: {
		0:{
    			id: 'string', 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'ciudad': {
// Tabla CDDLAFT_PERFIL_RIESGO_DEPARTAMENTO_CIUDAD, CDDLAFT_PERFIL_RIESGO_CIUDADES, CDDLAFT_PERFIL_RIESGO_DEPARTAMENTOS
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de residencia de los UBOs': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de residencia fiscal': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de incorporacion': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Estructura de propiedad compleja': {
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Tipo de persona jurídica': {
// Tabla CDDLAFT_PERFIL_RIESGO_TIPO_PERSONA_JURIDICA
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Presencia del Grupo': {
// Tabla CDDLAFT_PERFIL_RIESGO_GRUPOS
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Exposición a países prohibídos y Altamente restringidos': {

	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}}
POST:
catalogos: {'Industria': {
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}}
Por cada uno se requiere un guardado y eliminado, el mismo post puede servir como put, los campos de id se manejan como string por el requerimiento del banco y se planteó dejar todos como string.
2.
URL: /riesgo
get-post
Tabla // 
persona-natural: {
      industria: number,
      ocupacion: number,
      productos: number,
      paisResidencia: number,
      canalOnboarding: number,
      ciudad: number
    }
get-post
persona-juridica: {
      industria: number,
      productos: number,
      paisResidenciaUbos: number,
      paisResidenciaFiscal: number,
      paisIncorporacion: number,
      estructuraPropiedadCompleja: number,
      tipoPersonaJuridica: number,
      canalOnboarding: number,
      presenciaGrupo: number,
      exposicionPaisesProhibidos: number
    }
Son dos objetos que van a ser modificados constantemente.

3.
URL: /variables-riesgo
get-post
// Tabla CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE, CDDLAFT_PERFIL_TIPO_VARIABLE, CDDLAFT_PERFIL_GRUPO_VARIABLE
onboarding-ongoing: {
      porcentaje1: string,
      porcentaje2: string,
      fechaVigencia: date
}
4.
URL: /riesgo-total
get-post-delete
// Tabla CDDLAFT_PERFIL_RIESGO_CATALOGOS, CDDLAFT_INDICE_CATALOGOS, 
riesgo-total: {
  id: number;
  nombre: string;
  descripcion: string;
  riesgo: string;
  fechaVigencia: Date;
  limInf: string;
  limSup: string
  tipo: string
}
5.
URL: /resultado-riesgo
get
// Tabla CDDLAFT_PERFIL_RIESGO_NIVEL_RIESGO
resultado-riesgo:{
	id: number
	documento: 'number',
	tipoDocumento: 'string', 
	nombre: 'string', 
	tipoPersona: 'string', 
	producto: 'string', 
	fecha: 'date', 
	resultadoRiesgo: 'string', 
	nivelRiesgo: 'number'
}
get 
Informacion adicional:
por id de resultado-riesgo
id:{
   0:{
	Catálogo: string,
	Valor: string,
	Riesgo: number
    }...
}
 

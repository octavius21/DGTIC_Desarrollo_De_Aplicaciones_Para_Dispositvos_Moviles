const mongoose = require('mongoose');

const ProveedorSchema = new mongoose.Schema (
{
	_id : { type: Number, required: true },
    NombreCompania: { type: String, required: true },
    NombreContacto: { type: String, required: true },
    CargoContacto: { type: String, required: true },
    Direccion: { type: String, required: true },
    Ciudad: { type: String, required: true },
    Region: { type: String, required: false },
    CodPostal: { type: String, required: true },
    Pais: { type: String, required: true },
    Telefono: { type: String, required: true },
    Fax: { type: String, required: false },
    PaginaPrincipal: { type: String, required: false }
}, { collection: 'proveedores' }
);

mongoose.model ("Proveedor", ProveedorSchema);
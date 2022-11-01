const mongoose = require('mongoose');

const ProductoSchema = new mongoose.Schema (
{
	_id : { type: Number, required: true },
    NombreProducto: { type: String, required: true },
    IdProveedor: { type: Number, required: true },
    IdCategoria: { type: Number, required: true },
    CantidadPorUnidad: { type: String, required: true },
    PrecioUnidad: { type: Number, required: true },
    UnidadesEnExistencia: { type: Number, required: true }
}, { collection: 'productos' }
);

mongoose.model ("Producto", ProductoSchema);
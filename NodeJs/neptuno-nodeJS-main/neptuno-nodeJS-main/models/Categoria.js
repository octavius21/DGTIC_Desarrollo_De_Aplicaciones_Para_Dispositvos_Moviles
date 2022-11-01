const mongoose = require('mongoose');

const CategoriaSchema = new mongoose.Schema (
{
	_id: { type: Number, required: true },
    NombreCategoria: { type: String, required: true },
    Descripcion: { type: String, required: true }
}, { collection: 'categorias' }
);

mongoose.model ("Categoria", CategoriaSchema);
const mongoose = require('mongoose');
const Categoria = mongoose.model("Categoria");

function index (req, res, next) {
	Categoria.find().then( categorias => {
		res.send ( categorias );
	}).catch (next);
}

function find (req, res, next) {
	Categoria.findOne({ _id: req.params.id })
	.then( categoria => {
		res.send ( categoria );
	}).catch (next);
}

function agregar (req, res, next) {
	var categoria = new Categoria(req.body);
	categoria.save().then ( categoria => {
		res.status(201).send(categoria)
	}).catch(()=> { res.send("ERROR AL INSERTAR UNA Categoria")});
}

function eliminar (req, res, next) {
	Categoria.findOneAndDelete( {_id : req.params.id})
	.then (() => {
		res.send ("La Categoria se eliminó correctamente");
	})
	.catch(()=> { res.send("ERROR AL INTENTAR ELIMNAR LA Categoria")});
}

module.exports = {
	index,
	find,
	agregar,
	eliminar
}
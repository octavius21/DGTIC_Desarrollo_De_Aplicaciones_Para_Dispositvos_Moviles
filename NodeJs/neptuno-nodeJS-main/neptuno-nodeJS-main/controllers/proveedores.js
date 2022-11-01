const mongoose = require('mongoose');
const Proveedor = mongoose.model("Proveedor");

function index (req, res, next) {
	Proveedor.find().then( proveedores => {
		res.send ( proveedores );
	}).catch (next);
}

function find (req, res, next) {
	Proveedor.findOne({ _id : req.params.id })
	.then( proveedor => {
		res.send ( proveedor );
	}).catch (next);
}

function agregar (req, res, next) {
	var proveedor = new Proveedor(req.body);
	proveedor.save().then ( proveedor => {
		res.status(201).send(proveedor)
	}).catch(()=> { res.send("ERROR AL INSERTAR UN Proveedor")});
}

function eliminar (req, res, next) {
	Proveedor.findOneAndDelete( {_id: req.params.id})
	.then (() => {
		res.send ("El Proveedor se eliminó correctamente");
	})
	.catch(()=> { res.send("ERROR AL INTENTAR ELIMNAR UN Proveedor")});
}

module.exports = {
	index,
	find,
	agregar,
	eliminar
}
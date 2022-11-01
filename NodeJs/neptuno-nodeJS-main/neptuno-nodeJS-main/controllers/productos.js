const mongoose = require('mongoose');
const Producto = mongoose.model("Producto");

function index (req, res, next) {
	Producto.find().then( productos => {
		res.send ( productos );
	}).catch (next);
}

function find (req, res, next) {
	Producto.findOne({ _id : req.params.id })
	.then( producto => {
		res.send ( producto );
	}).catch (next);
}

function agregar (req, res, next) {
	var producto = new Producto(req.body);
	producto.save().then ( producto => {
		res.status(201).send(producto)
	}).catch(()=> { res.send("ERROR AL INSERTAR UN NUEVO PRODUCTO")});
}

function eliminar (req, res, next) {
	Producto.findOneAndDelete( {_id : req.params.id})
	.then (() => {
		res.send ("El producto ha sido eliminado correctamente");
	})
	.catch(()=> { res.send("ERROR AL INTENTAR ELIMNAR EL PRODUCTO")});
}

module.exports = {
	index,
	find,
	agregar,
	eliminar
}
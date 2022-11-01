var router = require("express").Router();
const {
	index,
	find,
	agregar,
	eliminar
} = require("../controllers/proveedores");

router.get ("/", index);
router.get ("/proveedor/:id", find);
router.post("/agregar", agregar);
router.delete ("/eliminar/:id", eliminar);

module.exports = router;
var router = require("express").Router();
const {
	index,
	find,
	agregar,
	eliminar
} = require("../controllers/categorias");

router.get ("/", index);
router.get ("/categoria/:id", find);
router.post("/agregar", agregar);
router.delete ("/eliminar/:id", eliminar);

module.exports = router;
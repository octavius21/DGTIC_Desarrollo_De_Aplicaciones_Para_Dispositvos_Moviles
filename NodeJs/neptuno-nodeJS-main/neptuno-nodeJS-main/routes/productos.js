var router = require("express").Router();
const {
	index,
	find,
	agregar,
	eliminar
} = require("../controllers/productos");

router.get ("/", index);
router.get ("/producto/:id", find);
router.post("/agregar", agregar);
router.delete ("/eliminar/:id", eliminar);

module.exports = router;
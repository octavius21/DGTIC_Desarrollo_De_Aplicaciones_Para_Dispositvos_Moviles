var router = require('express').Router();

router.get ("/", (req, res, next) => {
	res.send ("<h1>Bienvenido a Importadora Neptuno</h1>");
});

router.use ("/productos", require("./productos"));
router.use ("/categorias", require("./categorias"));
router.use ("/proveedores", require("./proveedores"));

module.exports = router;

require recipes-core/images/core-image-minimal-dev.bb

DEPENDS = "linux-yocto"

IMAGE_FEATURES += "package-management ssh-server-dropbear"
EXTRA_IMAGE_FEATURES = "tools-debug debug-tweaks tools-profile dbg-pkgs"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	rt-app \
	schedtool-dl \
	"

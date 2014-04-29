DESCRIPTION = "schedtool-dl (scheduler test tool) for deadline scheduler"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc1f51f7ca94aebffb9b3663d82873ec"

SRC_URI = "git://github.com/jlelli/schedtool-dl.git;protocol=git"
SRCREV = "3ffb479929c31cbae09de08f94f58b8f0f061d91"

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake
}

do_install() {
     	install -d ${D}${bindir}
     	install -m 0755 schedtool ${D}${bindir}
}

FILES_{PN} = "${bindir}/schedtool" 

PARALLEL_MAKE = ""

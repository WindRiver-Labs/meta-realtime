DESCRIPTION = "schedtool-dl (scheduler test tool) for deadline scheduler"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;endline=55;md5=e4b4e8ed9c2132e1d727a1bb5e3bd984"
PR = "r1"

SRC_URI = "git://github.com/jlelli/schedtool-dl.git;protocol=git"
SRCREV = "cd4e3f2f5a33c3266e25e447e8efbacb3b8c88da"

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

SUMMARY = "OpenYard Application"
DESCRIPTION = "OpenYard Application"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4908b1e39cc61772e5d74e5fb77d241"

FILESEXTRAPATHS_prepend := "${THISDIR}/../../src/:"

SRC_URI = "file://openyard_app \
"

S = "${WORKDIR}/openyard_app"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_DEFAULT_DEPS = "1"

do_install() {
    # Main Qt application
    install -d ${D}${datadir}/${P}
    # install -m 0755 ${B}/openyard_app ${D}${datadir}/${P}
    cp -a ${S}/ ${D}${datadir}/${P}
}


FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"


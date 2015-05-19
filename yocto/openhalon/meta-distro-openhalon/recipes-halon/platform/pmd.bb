SUMMARY = "Halon Pluggable Module Daemon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;beginline=0;endline=14;md5=90baf0d21acabd54e99d75cfac782f1a"

DEPENDS = "halonutils config-yaml halon-ovsdb"

SRC_URI = "git://git.openhalon.io/openhalon/pmd;protocol=http;preserve_origin=1 \
           file://pmd.service \
"

SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

do_install_append() {
     install -d ${D}${systemd_unitdir}/system
     install -m 0644 ${WORKDIR}/pmd.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "pmd.service"

inherit halon cmake systemd
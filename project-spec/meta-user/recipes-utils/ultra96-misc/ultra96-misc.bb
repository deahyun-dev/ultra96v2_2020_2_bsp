DESCRIPTION = "Custom / Misc files for Ultra96-V2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://minized-mount.sh \
	    file://wpa_supplicant.conf \
	    file://wifi.sh \
	    file://bt.sh \
" 
inherit update-rc.d
INITSCRIPT_NAME = "wifi.sh"
INITSCRIPT_PARAMS = "start 120 5 2 ."

do_install() {
	install -d ${D}/home/root/
	install -m 755 ${WORKDIR}/wpa_supplicant.conf ${D}/home/root/
	install -m 755 ${WORKDIR}/wifi.sh ${D}/home/root/
	install -m 755 ${WORKDIR}/bt.sh ${D}/home/root/
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/wifi.sh ${D}${sysconfdir}/init.d/wifi.sh
}


FILES_${PN} = " \
		/home/root/wpa_supplicant.conf \
		/home/root/wifi.sh \
		/home/root/bt.sh \
"
FILES_${PN} += "${sysconfdir}/*"
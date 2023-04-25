# Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
#
# This file is part of Ntro
#
# Ntro is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Ntro is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

##### INCLUDE #####
this_dir=$(readlink -f "$0")
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

save_dir

cd "$root_dir"

echo ""
echo "Entrer le nom du projet en minuscules avec des _ (comme un nom de paquet Java)"
echo ""

echo -n "> "
read nom_projet

echo ""
echo "Voici le nom du paquet: $nom_projet"
echo "Est-ce OK?"
echo ""

echo "Saisir OUI pour effectuer le renommage ou autre touche pour annuler"
echo ""

read reponse

echo ""
echo ""

if [ "$reponse" = "OUI" -o "$reponse" = "oui" ]; then

    echo "RENOMMAGE"
    echo ""

    find mon_projet -name "*.java" -o -name "*.xml" -o -name "*.gradle" | while read i; do echo "renommage dans: $i"; sed "s/mon_projet/$nom_projet/g" -i "$i"; done

    mv -v "mon_projet/src/main/java/mon_projet" "mon_projet/src/main/java/$nom_projet"
    mv -v "mon_projet" "$nom_projet"


else
    echo "RENOMMAGE ANNULÉ"
    echo ""
fi




restore_dir
